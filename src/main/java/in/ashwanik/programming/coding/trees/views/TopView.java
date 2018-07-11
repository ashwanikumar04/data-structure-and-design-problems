package in.ashwanik.programming.coding.trees.views;


import in.ashwanik.programming.coding.trees.TreeBuilder;
import in.ashwanik.programming.coding.trees.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 */
public class TopView {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.createIntegerDynamicTree();
        root.printTree();
        System.out.println("\n");
        topView(root);
    }

    public static class QItem<T> {
        T data;
        int hd;

        public QItem(T data, int hd) {
            this.data = data;
            this.hd = hd;
        }
    }

    private static void topView(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Map<Integer, TreeNode<Integer>> levelMap = new TreeMap<>();
        updateLevel(root, levelMap);

    }

    private static void updateLevel(TreeNode<Integer> root, Map<Integer, TreeNode<Integer>> levelMap) {
        if (root == null) {
            return;
        }

        Queue<QItem<TreeNode<Integer>>> queue = new LinkedList<>();
        queue.add(new QItem<>(root, 0));
        while (!queue.isEmpty()) {
            QItem<TreeNode<Integer>> current = queue.remove();
            if (!levelMap.containsKey(current.hd)) {
                levelMap.put(current.hd, current.data);
            }
            if (current.data.getLeft() != null) {
                queue.add(new QItem<>(current.data.getLeft(), current.hd - 1));
            }
            if (current.data.getRight() != null) {
                queue.add(new QItem<>(current.data.getRight(), current.hd + 1));
            }
        }

        for (Map.Entry<Integer, TreeNode<Integer>> entry : levelMap.entrySet()) {
            System.out.print(entry.getValue().getData() + "\t");
        }
    }


}
