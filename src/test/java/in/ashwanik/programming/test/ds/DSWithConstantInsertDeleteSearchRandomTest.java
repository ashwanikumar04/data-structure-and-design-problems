package in.ashwanik.programming.test.ds;

import in.ashwanik.programming.coding.ds.DSWithConstantInsertDeleteSearchRandom;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DSWithConstantInsertDeleteSearchRandomTest {
    @Test
    public void testSearch() {
        DSWithConstantInsertDeleteSearchRandom<Integer> dsWithConstantInsertDeleteSearchRandom =
                new DSWithConstantInsertDeleteSearchRandom<>();
        dsWithConstantInsertDeleteSearchRandom.add(3);
        dsWithConstantInsertDeleteSearchRandom.add(6);
        dsWithConstantInsertDeleteSearchRandom.add(10);
        dsWithConstantInsertDeleteSearchRandom.add(50);
        assertThat(dsWithConstantInsertDeleteSearchRandom.search(3)).isEqualTo(0);
    }

}
