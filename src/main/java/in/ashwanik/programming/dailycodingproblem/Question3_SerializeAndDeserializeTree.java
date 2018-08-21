package in.ashwanik.programming.dailycodingproblem;

import in.ashwanik.programming.coding.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.
 */
public class Question3_SerializeAndDeserializeTree {

    public String serialize(TreeNode<Integer> root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        ///Adding dummy node as Deque does not allow null
        TreeNode<Integer> dummy = new TreeNode<>(1);
        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            if (node != dummy) {
                stringBuilder.append(node.getData());
                stringBuilder.append(",");
                if (node.getLeft() == null) {
                    stack.push(dummy);
                } else {
                    stack.push(node.getLeft());
                }
                if (node.getRight() == null) {
                    stack.push(dummy);
                } else {
                    stack.push(node.getRight());
                }
            } else {
                stringBuilder.append("#,");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();

    }

    public TreeNode<Integer> deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodeData = data.split(",");
        return null;
    }
}
