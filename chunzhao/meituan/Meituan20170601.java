package meituan;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年6月11日下午12:45:29
 */
public class Meituan20170601 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = scan.nextInt();
        }
        int sum = Integer.MAX_VALUE;
        for (int j = 0; j < m - n; j++) {
            int temp = 0;
            int k = j;
            for (int i = 0; i < n; i++, k++) {
                temp = temp + (nums2[k] - nums1[i]) * (nums2[k] - nums1[i]);
            }
            //System.out.println(sum);
            if (sum > temp) {
                sum = temp;
            }
        }
        System.out.println(sum);

        scan.close();
    }

}
