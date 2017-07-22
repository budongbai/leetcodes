package zhaohangxinyongka;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月13日下午6:56:26
 */
public class Main1 {

    public static int gcd(int min, int max) {
        while (max % min != 0) {
            int k = max % min;
            max = min;
            min = k;
        }
        return min;
    }

    // 求最小公倍数
    public static int lcm(int min, int max) {
        return min * max / gcd(min, max);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();

        int b = scan.nextInt();
        int n = scan.nextInt();
        if (b < a) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(n / lcm(a, b));
        scan.close();
    }

}
