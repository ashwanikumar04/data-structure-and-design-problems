package in.ashwanik.programming.test.tree;

import in.ashwanik.programming.dailycodingproblem.Question3_SerializeAndDeserializeTree;
import in.ashwanik.programming.coding.trees.TreeBuilder;
import in.ashwanik.programming.coding.trees.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Question3SerializeAndDeserializeTreeTest {

    @Test
    public void testSerialize() {
        TreeNode<Integer> root = TreeBuilder.createIntegerDynamicTree();
        Question3_SerializeAndDeserializeTree question3SerializeAndDeserializeTree = new Question3_SerializeAndDeserializeTree();
        String data = question3SerializeAndDeserializeTree.serialize(root);
        assertThat(data.split(",").length).isEqualTo(15);
    }

    @Test
    public void testDeserialize() {
        TreeNode<Integer> root = TreeBuilder.createIntegerDynamicTree();
        Question3_SerializeAndDeserializeTree question3SerializeAndDeserializeTree = new Question3_SerializeAndDeserializeTree();
        String data = question3SerializeAndDeserializeTree.serialize(root);
        assertThat(data.split(",").length).isEqualTo(15);
    }
}
