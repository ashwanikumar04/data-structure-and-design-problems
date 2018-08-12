package in.ashwanik.programming.test.arrays;

import in.ashwanik.programming.coding.arrays.ProductOfElementsExceptCurrent;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductOfElementsExceptCurrentTest {

    @Test
    public void testProductNull() {
        int[] array = null;
        assertThat(new ProductOfElementsExceptCurrent().product1(array)).isEqualTo(array);
    }

    @Test
    public void testProduct1() {
        int[] array = {3, 2, 1};
        int[] result = new ProductOfElementsExceptCurrent().product1(array);
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(3);
        assertThat(result[2]).isEqualTo(6);
    }

    @Test
    public void testProduct2() {
        int[] array = {3, 2, 1};
        int[] result = new ProductOfElementsExceptCurrent().product2(array);
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(3);
        assertThat(result[2]).isEqualTo(6);
    }


}
