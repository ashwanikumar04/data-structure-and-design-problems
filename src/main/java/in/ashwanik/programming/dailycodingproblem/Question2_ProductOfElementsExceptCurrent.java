package in.ashwanik.programming.dailycodingproblem;


/*
   Given an array of integers, return a new array such that each element at index i of the new array
   is the product of all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
    If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class Question2_ProductOfElementsExceptCurrent {

    public int[] product1(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int length = array.length;

        int[] result = new int[length];

        int[] left = new int[length];

        left[0] = 1;
        for (int index = 1; index < length; index++) {
            left[index] = array[index - 1] * left[index - 1];
        }

        int[] right = new int[length];

        right[length - 1] = 1;
        for (int index = length - 2; index >= 0; index--) {
            right[index] = array[index + 1] * right[index + 1];
        }

        for (int index = 0; index < length; index++) {
            result[index] = left[index] * right[index];
        }

        return result;
    }

    public int[] product2(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int length = array.length;

        int[] result = new int[length];

        int temp = 1;

        for (int index = 0; index < length; index++) {
            result[index] = temp;
            temp *= array[index];
        }

        temp = 1;
        for (int index = length - 1; index >= 0; index--) {
            result[index] *= temp;
            temp *= array[index];
        }

        return result;
    }
}
