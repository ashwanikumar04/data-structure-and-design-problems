package in.ashwanik.programming.coding.arrays;

public class ProductOfElementsExceptCurrent {

    /*
        //input:  [3,2,1]
        //output: [2,3,6]


        //input:  [1,2,3,4,5]
        //output: [120,60,40,30,24]
     */
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
