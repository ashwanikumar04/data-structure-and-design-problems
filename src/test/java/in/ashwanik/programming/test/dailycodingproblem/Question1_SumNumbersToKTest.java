package in.ashwanik.programming.test.dailycodingproblem;

import in.ashwanik.programming.dailycodingproblem.Question1_SumNumbersToK;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Question1_SumNumbersToKTest {

    @Test
    public void testSumExistsForNull() {
        int[] array = null;
        assertThat(new Question1_SumNumbersToK().sumexists(array, 5)).isFalse();
    }

    @Test
    public void testSumExistsTrue() {
        int[] array = {10, 5};
        assertThat(new Question1_SumNumbersToK().sumexists(array, 10)).isFalse();
    }
}
