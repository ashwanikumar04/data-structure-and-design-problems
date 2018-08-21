package in.ashwanik.programming.dailycodingproblem;

import java.util.HashMap;
import java.util.Map;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Question1_SumNumbersToK {

    public boolean sumexists(int[] array, int sum) {
        if (array == null || array.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            map.put(i, map.get(i) + 1);
        }

        for (int i : array) {
            int number = sum - i;
            if (number == i) {
                return map.get(number) > 1;
            } else {
                return map.containsKey(sum - i);
            }
        }
        return false;
    }
}
