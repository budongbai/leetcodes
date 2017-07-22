package wangyi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月12日下午2:42:44
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] dp = new int[k + 5][n + 5];
        dp[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum += dp[j][i - 1];
                sum %= 1000000007;
            }
            for (int j = 1; j <= k; j++) {
                int sum2 = 0;
                for (int z = j + j; z <= k; z += j) {
                    sum2 += dp[z][i - 1];
                    sum2 %= 1000000007;
                }
                dp[j][i] = (sum - sum2 + 1000000007) % 1000000007;
            }
        }
        int result = 0;
        for (int i = 0; i <= k; i++) {
            result += dp[i][n];
            result %= 1000000007;
        }
        System.out.println(result);
        in.close();
    }
}
