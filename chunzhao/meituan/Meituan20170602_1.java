package meituan;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年6月11日下午12:45:29
 */

public class Meituan20170602_1 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = scan.nextInt();
        }
        int xiaoMei = score[0];
        int count = 0;
        int round = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] <= xiaoMei) {
                count++;
            }
        }
        System.out.println("count:" + count);

        round = (new Double(Math.log(count * 1.0) / Math.log(2.0)).intValue());
        System.out.println(round);
        scan.close();
    }

}

