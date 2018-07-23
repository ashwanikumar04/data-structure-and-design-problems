package in.ashwanik.programming.coding.trees.views;


import in.ashwanik.programming.coding.trees.TreeBuilder;
import in.ashwanik.programming.coding.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 */
public class LeftView {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.createIntegerDynamicTree();
        root.printTree();
        System.out.println("\n");
        leftView(root);
    }


    private static <T> void leftView(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        /**
         * ArrayDeque does not allow null so using a dummy node
         */
        TreeNode<T> dummy = root.getDummy();
        Queue<TreeNode<T>> queue = new ArrayDeque<>();

        queue.add(root);
        queue.add(dummy);
        System.out.println(root.getData());
        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.remove();
            if (current == dummy) {
                if (!queue.isEmpty()) {
                    queue.add(dummy);
                    System.out.println(queue.peek().getData());
                }
            } else {
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }

        }
    }


}
