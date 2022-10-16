package Recursion;

/*1. Написать программу по возведению числа в степень с помощью рекурсии.*/

public class Task1 {

    public static void main(String[] args) {
        System.out.println(exponentation(2, 10));
        System.out.println(degree(2, 10));
    }

    static int degree(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            int halfDegreeResult = degree(x, n / 2);
            return halfDegreeResult * halfDegreeResult;
        }
        return x * degree(x, n - 1);
    }

    static int exponentation(int n, int degree) {
        if (degree < 0) {
            throw new ArithmeticException("use positive exponent numbers");
        }
        if (degree == 0) {
            return 1;
        }
        if (degree == 1) {
            return n;
        }
        return n * exponentation(n, degree - 1);
    }

}
