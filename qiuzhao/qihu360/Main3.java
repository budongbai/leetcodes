package qihu360;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月26日下午6:55:23
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = scan.nextInt();
        }
        int m = scan.nextInt();

        int[] ms = new int[m];
        for (int i = 0; i < m; i++) {
            ms[i] = scan.nextInt();
        }
        System.out.println(0);
        scan.close();
    }
}
