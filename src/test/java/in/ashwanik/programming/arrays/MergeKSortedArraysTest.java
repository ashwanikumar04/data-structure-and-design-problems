package in.ashwanik.programming.arrays;

import in.ashwanik.programming.coding.arrays.MergeKSortedArrays;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeKSortedArraysTest {
    @Test
    public void testMergeNull() {
        int[][] array = null;
        assertThat(new MergeKSortedArrays().merge(array)).isEqualTo(new int[0]);
    }

    @Test
    public void testMerge() {
        int[][] array = {{1, 2, 3}, {4}};
        int[] result = new MergeKSortedArrays().merge(array);
        assertThat(result.length).isEqualTo(4);
        assertThat(result[3]).isEqualTo(4);
    }
}
