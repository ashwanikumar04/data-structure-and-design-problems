package in.ashwanik.programming.test.tree;

import in.ashwanik.programming.coding.trees.SerializeAndDeserializeTree;
import in.ashwanik.programming.coding.trees.TreeBuilder;
import in.ashwanik.programming.coding.trees.TreeNode;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SerializeAndDeserializeTreeTest {

    @Test
    public void testSerialize() {
        TreeNode<Integer> root = TreeBuilder.createIntegerDynamicTree();
        SerializeAndDeserializeTree serializeAndDeserializeTree = new SerializeAndDeserializeTree();
        String data = serializeAndDeserializeTree.serialize(root);
        assertThat(data.split(",").length).isEqualTo(15);
    }

    @Test
    public void testDeserialize() {
        TreeNode<Integer> root = TreeBuilder.createIntegerDynamicTree();
        SerializeAndDeserializeTree serializeAndDeserializeTree = new SerializeAndDeserializeTree();
        String data = serializeAndDeserializeTree.serialize(root);
        assertThat(data.split(",").length).isEqualTo(15);
    }
}
