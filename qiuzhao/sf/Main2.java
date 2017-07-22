package sf;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月20日下午3:58:54
 */
public class Main2 {
    public static boolean isLuck(long x) {
        long t;
        while (x != 0) {
            t = x % 10;
            if (t != 4 && t != 7) return false;
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int len = 1000000009;
        //相当于求2+...+ 2^bit = 2^(bit+1)-2;
        int bit = bit(n);

        int res = pow(2, bit) - 2;
        long start = 4;
        long end = 7;
        int k = 1;
        while (k < bit) {
            start = start * 10 + 4;
            end = end * 10 + 7;
            k++;
        }
        //System.out.println(start + ","+ end);
        for (long i = start; i <= (end > n ? n : end); i++) {
            if (isLuck(i)) {
                res++;
            }
        }
        //System.out.println(Math.pow(10, 100000));
        System.out.println(res);
    }


    public static int bit(long n) {
        int bit = 0;
        while (n != 0) {
            n /= 10;
            bit++;
        }
        return bit;
    }

    public static int pow(int n, int bit) {
        int res = 1;
        int count = 0;
        while (count < bit) {
            res = res * n % 1000000009;
            count++;
        }
        return res;
    }

}
