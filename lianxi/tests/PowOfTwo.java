package tests;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月20日下午11:05:54
 */
public class PowOfTwo {
    public static boolean fn(int x) {
        if ((x & (x - 1)) != 0) {// 判断x是否为2的幂次方
            return false;
        }
        return (x & 0x55555555) != 0; // 判断1是否在奇数位置上
    }

    public static boolean fn8(int x) {
        if ((x & (x - 1)) != 0) {// 判断x是否为2的幂次方
            return false;
        }
        return (x & 0x49249249) != 0;
    }

    public static int log4(int value) {
        if (value <= 1)
            return 0;
        else {
            value >>= 1; // 往右移位
            return 1 + log4(value >> 1); // 往右移位
        }
    }

    public static int log42(int value) {
        int x = 0;
        while (value > 1) {
            value >>= 1;
            value >>= 1;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(fn(n));
        System.out.println(fn8(n));
        System.out.println(log4(n));
        System.out.println(log42(n));
        scan.close();
    }

}
