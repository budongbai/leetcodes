package wangyi;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月12日下午2:42:44
 */
public class Main2Mine {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = scan.nextInt();
        }
        long[][] dp = new long[n][n];
        long[] res = new long[n];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
            }
            Arrays.sort(dp[i]);
            for (int j = 1; j < n; j++) {
                dp[i][j] += dp[i][j - 1];
                res[j] = Math.min(res[j], dp[i][j]);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[n - 1]);
        scan.close();

    }
}
