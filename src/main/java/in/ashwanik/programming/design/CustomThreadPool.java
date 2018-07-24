package in.ashwanik.programming.design;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class CustomThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool(2, 2); //create 2 threads in ThreadPool
        Runnable task = () -> {

            System.out.println(Thread.currentThread().getName()
                    + " is executing task.");

        };
        threadPool.execute(task);
        threadPool.execute(task);

        threadPool.stop();
    }


    public interface BlockingQueue<E> {

        void put(E item) throws InterruptedException;

        E take() throws InterruptedException;

        int size();
    }


    public static class BlockingListQueue<E> implements BlockingQueue<E> {

        List<E> items;
        int maxSize;

        public BlockingListQueue(int size) {
            maxSize = size;
            items = new ArrayList<>(size);
        }


        @Override
        public void put(E item) throws InterruptedException {
            synchronized (items) {
                if (items.size() == maxSize) {
                    items.wait();
                }

                items.add(item);
                items.notifyAll();
            }


        }

        @Override
        public E take() throws InterruptedException {
            synchronized (items) {

                if (items.size() == 0) {
                    items.wait();
                }
                E item = items.remove(0);
                items.notifyAll();
                return item;
            }
        }

        @Override
        public int size() {
            synchronized (items) {
                return items.size();

            }
        }
    }


    public static class ThreadPool {
        BlockingQueue<Runnable> taskQueue;
        List<PoolThread> threads;
        boolean isStopped;

        public ThreadPool(int numberOfThreads, int maxTasks) {
            taskQueue = new BlockingListQueue<>(maxTasks);
            threads = new ArrayList<>();
            for (int index = 0; index < numberOfThreads; index++) {
                threads.add(new PoolThread(taskQueue));
            }
            threads.forEach(PoolThread::start);
        }

        public synchronized void execute(Runnable runnable) throws InterruptedException {
            if (isStopped) {
                throw new IllegalStateException("Thread pool is stopped");
            }
            taskQueue.put(runnable);
        }

        public synchronized void stop() {
            isStopped = true;
            threads.forEach(PoolThread::stopTask);
        }


    }


    public static class PoolThread extends Thread {

        BlockingQueue<Runnable> taskQueue;
        private boolean stopped;

        public PoolThread(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;

        }

        @Override
        public void run() {
            while (!stopped) {
                try {
                    Runnable runnable = taskQueue.take();
                    System.out.println("Starting task: " + Thread.currentThread().getName());
                    runnable.run();
                    System.out.println("Completed task: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        public synchronized void stopTask() {
            stopped = true;
            this.interrupt();
        }


        public synchronized boolean isStopped() {
            return stopped;
        }
    }

}
