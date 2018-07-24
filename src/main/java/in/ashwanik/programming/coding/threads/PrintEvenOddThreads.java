package in.ashwanik.programming.coding.threads;

/**
 */
public class PrintEvenOddThreads {


    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread odd = new Thread(new NumberGenerator(true, 10, printer));
        odd.setName("Odd");

        Thread even = new Thread(new NumberGenerator(false, 10, printer));
        even.setName("Even");

        even.start();
        odd.start();
    }

    public static class Printer {
        private boolean isEvenPrinted = true;

        public void printEven(int number) throws InterruptedException {
            synchronized (this) {
                if (isEvenPrinted) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                isEvenPrinted = true;
                notifyAll();
            }
        }

        public void printOdd(int number) throws InterruptedException {
            synchronized (this) {
                if (!isEvenPrinted) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                isEvenPrinted = false;
                notifyAll();
            }
        }
    }

    public static class NumberGenerator implements Runnable {
        private boolean isOdd;
        private int max;
        private Printer printer;
        private int start;

        public NumberGenerator(boolean isOdd, int max, Printer printer) {
            this.isOdd = isOdd;
            this.max = max;
            this.printer = printer;
            start = isOdd ? 1 : 2;
        }

        @Override
        public void run() {
            for (int index = 0; index < max; index++) {
                if (isOdd) {
                    try {
                        printer.printOdd(start);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        printer.printEven(start);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                start += 2;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
