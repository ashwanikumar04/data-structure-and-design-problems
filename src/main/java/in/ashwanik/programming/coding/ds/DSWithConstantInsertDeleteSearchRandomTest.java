package in.ashwanik.programming.coding.ds;

import java.util.*;

/**
 * A data structure which provides constant time INSERT, DELETE, SEARCH and RANDOM
 */

public class DSWithConstantInsertDeleteSearchRandomTest {
    public static void main(String[] args) {

        DSWithConstantInsertDeleteSearchRandom<Integer> dsWithConstantInsertDeleteSearchRandom =
                new DSWithConstantInsertDeleteSearchRandom<>();
        dsWithConstantInsertDeleteSearchRandom.add(3);
        dsWithConstantInsertDeleteSearchRandom.add(6);
        dsWithConstantInsertDeleteSearchRandom.add(10);
        dsWithConstantInsertDeleteSearchRandom.add(50);
        dsWithConstantInsertDeleteSearchRandom.print();
        dsWithConstantInsertDeleteSearchRandom.delete(3);
        dsWithConstantInsertDeleteSearchRandom.print();
        System.out.println(dsWithConstantInsertDeleteSearchRandom.random());

    }

    public static class DSWithConstantInsertDeleteSearchRandom<T> {

        private HashMap<T, Integer> hashMap;
        private ArrayList<T> arrayList;
        private Random random;

        public DSWithConstantInsertDeleteSearchRandom() {
            hashMap = new HashMap<>();
            arrayList = new ArrayList<>();
            random = new Random();
        }

        public void add(T data) {
            if (hashMap.containsKey(data)) {
                return;
            }

            arrayList.add(data);
            hashMap.put(data, arrayList.size() - 1);
        }

        public void delete(T data) {

            Integer index = hashMap.get(data);
            if (index == null) {
                return;
            }

            Collections.swap(arrayList, index, arrayList.size() - 1);
            hashMap.remove(data);
            hashMap.put(arrayList.get(index), index);
            arrayList.remove(arrayList.size() - 1);
        }


        public Integer search(T data) {
            return hashMap.get(data);

        }

        public T random() {
            int number = random.nextInt(arrayList.size());
            return arrayList.get(number);
        }

        public void print() {
            System.out.println(Arrays.toString(arrayList.toArray()));
        }

    }


}
