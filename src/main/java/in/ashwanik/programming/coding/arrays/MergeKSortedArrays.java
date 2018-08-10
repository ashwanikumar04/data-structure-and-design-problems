package in.ashwanik.programming.coding.arrays;

import java.util.PriorityQueue;

public class MergeKSortedArrays {

    private static class Node implements Comparable<Node> {

        int array;
        int index;
        int value;

        public Node(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            int result = 0;
            if (o.value < value) {
                result = 1;
            } else if (o.value > value) {
                result = -1;
            }
            return result;
        }
    }

    public int[] merge(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        int size = 0;
        for (int index = 0; index < arrays.length; index++) {
            size += arrays[index].length;
            if (arrays[index].length > 0) {
                queue.offer(new Node(index, 0, arrays[index][0]));
            }
        }
        int[] result = new int[size];

        int resultIndex = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result[resultIndex++] = node.value;
            int newIndex = node.index + 1;
            if (newIndex < arrays[node.array].length) {
                queue.offer(new Node(node.array, newIndex, arrays[node.array][newIndex]));
            }
        }
        return result;
    }
}
