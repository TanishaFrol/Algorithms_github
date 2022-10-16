package LinkedList;

import java.util.Iterator;

public class MyArrayIterator {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        ArrayIterable arrayIterator = new ArrayIterable(array);

        for (Integer integer : arrayIterator) {
            System.out.println(integer);
        }
    }

    static class ArrayIterable implements Iterable<Integer> {
        private final int[] arr;

        public ArrayIterable(int[] arr) {
            this.arr = arr;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new ArrayIterator();
        }

        private class ArrayIterator implements Iterator<Integer> {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < arr.length;
            }

            @Override
            public Integer next() {
                return arr[cursor++];
            }
        }
    }
}
