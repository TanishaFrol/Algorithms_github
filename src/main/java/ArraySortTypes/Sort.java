package ArraySortTypes;

import java.util.Arrays;

public class Sort {
    private static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{8, 6, 4, 5, 7, 2, 3, 9, 1};
        System.out.println("Исходный массив:\n" + Arrays.toString(arr));

        System.out.println("Пузырьковая сортировка:\n" + Arrays.toString(sortBubble(arr)));

        System.out.println("Сортировка методом выбора:\n" + Arrays.toString(sortSelect(arr)));

        System.out.println("Сортировка методом вставки:\n" + Arrays.toString(sortInsert(arr)));
    }
    public static int[] sortBubble(int[] arr){
        int out, in;
        for (out = arr.length - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
        return arr;
    }
    private static void change(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static int[] sortSelect(int[] arr){
        int out, in, mark;
        for(out=0;out<arr.length;out++){
            mark = out;
            for(in = out+1;in<arr.length;in++){
                if (arr[in]< arr[mark]){
                    mark = in;
                }
            } change(out, mark);
        }
        return arr;
    }
    public static int[] sortInsert(int[] arr){
        int in, out;
        for(out = 1; out < arr.length; out++){
            int temp = arr[out];
            in = out;
            while(in > 0 && arr[in-1] >=temp){
                arr[in] = arr[in-1];
                --in;
            } arr[in] = temp;
        }
        return arr;
    }

}
