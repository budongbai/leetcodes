package meituan;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年6月11日下午12:45:29
 */
public class Meituan20170602 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        nums[0] = scan.nextInt();

        int elCount = 1;
        //int com = 2;
        int count = 0;
        /*
         * for (int i = 1; i < n; i++) { nums[i] = scan.nextInt(); if (nums[i]
         * <= nums[0]) { if (elCount < com) { elCount++; } else { count++; if
         * (count == 1) { com = 2; } else { com <<= 1; } elCount = 0; } } }
         */
        for (int i = 1; i < n; i++) {
            nums[i] = scan.nextInt();
            if (nums[i] <= nums[0]) {
                elCount++;
            }
        }

        // System.out.println((int)(Math.floor(Math.log(elCount)/Math.log(2))));

        while (elCount > 1) {
            elCount = elCount / 2;

            count++;
        }
        System.out.println(count);

        scan.close();
    }

    public int Func3(int data) { // 利用了data&(data-1)每次都能移除最右边的1，移除了多少个1，就是包含了几个1
        int count = 0;
        while (data != 0) {
            count = count + data & 0x01;
            data >>= 1;
        }
        return count;
    }

    public static int clp2(int x) {
        // 0010 1100 0000 0000 0000 0000 0000 0000 0000 0001
        x = x - 1; // 0010 1100 0000 0000 0000 0000 0000 0000 0000 0000
        x = x | (x >> 1); // 0011 1110 0000 0000 0000 0000 0000 0000 0000 0000
        x = x | (x >> 2); // 0011 1111 1000 0000 0000 0000 0000 0000 0000 0000
        x = x | (x >> 4); // 0011 1111 1111 1000 0000 0000 0000 0000 0000 0000
        x = x | (x >> 8); // 0011 1111 1111 1111 1111 1000 0000 0000 0000 0000
        x = x | (x >> 16); // 0011 1111 1111 1111 1111 1111 1111 1111 1111 1111
        return x + 1; // 0100 0000 0000 0000 0000 0000 0000 0000 0000 0000
    }

    public static int clz2(int a) {
        int n = 0;
        if ((0xF0 & a) == 0) {
            n += 4;
            a = (int) (a << 4);
        }
        if ((0xC0 & a) == 0) {
            n += 2;
            a = (int) (a << 2);
        }
        if ((0x80 & a) == 0) {
            n += 1;
        }
        return n;
    }

}
