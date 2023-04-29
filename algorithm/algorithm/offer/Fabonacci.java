package algorithm.offer;

public class Fabonacci {
    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciWithIterator(int n) {
        if (n < 2) {
            return n;
        }
        int n0 = 0;
        int n1 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = n0 + n1;
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciWithIterator(8));
    }

}
