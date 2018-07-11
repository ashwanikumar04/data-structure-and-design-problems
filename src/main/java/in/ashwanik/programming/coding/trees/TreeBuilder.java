package in.ashwanik.programming.coding.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 */
public class TreeBuilder {

    public static TreeNode<Integer> createIntegerDynamicTree() {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 27, 9, 37, 4, 57, 6));
        return createDynamicTree(arrayList);
    }


    public static <T> TreeNode<T> createDynamicTree(ArrayList<T> dataList) {
        Random random = new Random();
        TreeNode<T> root = new TreeNode<>(dataList.get(random.nextInt(dataList.size())));
        root.setLeft(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.setRight(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.getLeft().setLeft(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.getRight().setLeft(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));

        root.getLeft().setRight(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        root.getRight().setRight(new TreeNode<>(dataList.get(random.nextInt(dataList.size()))));
        return root;

    }


}
