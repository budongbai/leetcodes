package union;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月20日下午2:45:28
 */
public class Main3 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            int n = scan.nextInt();

            int[] v = new int[n];
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 0; i < n; ++i)
                v[i] = scan.nextInt();
            // dp[p][i] 以i开始 长度为p能得到的最大值
            for (int p = 1; p <= n; ++p) {
                for (int i = 0; i <= n - p; ++i) {
                    dp[p][i] = Math.max(dp[p - 1][i] + v[i + p - 1] * (n - p + 1),
                        dp[p - 1][i + 1] + v[i] * (n - p + 1));
                }
            }
            System.out.println(dp[n][0]);
        }
    }

}
