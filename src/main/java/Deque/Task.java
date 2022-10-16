package Deque;

/*    Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено.
      Необходимо вывести на экран пропущенное число. Постарайтесь придумать более оптимальный (асимптотически) алгоритм. Примеры:
            1. [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
            2. [1, 2, 4, 5, 6] => 3
            3. [2, 3, 4, 5, 6, 7, 8] => 1
            4. [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14] => 15
            5. [] => 1*/

public class Task {

    public static void main(String[] args) {
        System.out.println("result: " + findLostElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}));
        System.out.println("result: " + findLostElement2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}));
        System.out.println("result: " + findLostElement3(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16}));

    }

    static int findLostElement(int[] arr) {  // O(n)
        if (arr.length == 0) return 1;
        else if (!(arr[0] == 1)) return 1;
        else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (!(arr[i + 1] - arr[i] == 1))
                    return arr[i] + 1;
            }
        }
        return arr[arr.length - 1] + 1;
    }

    static int findLostElement2(int[] arr) {  // O(n^2)
        long result = factorial(arr.length + 1);
        if (arr.length == 0) return 1;
        else {
            for (int i = 0; i < arr.length; i++) {
                result /= arr[i];
            }
            return (int) result;
        }
    }

    public static long factorial(long n) {
        if (n == 1)
            return n;
        return n * factorial(n - 1);
    }

    static int findLostElement3(int[] arr) {  // O(log(n))
        if (arr == null || arr.length == 0) {
            return 1;
        } else {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int m = (right + left) / 2;
                int element = arr[m];
                if (m + 1 == element) {
                    left = m + 1;
                    continue;
                }
                right = m;
            }
            return arr[left] - 1;
        }
    }
}
