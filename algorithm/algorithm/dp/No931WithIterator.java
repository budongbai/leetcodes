

package algorithm.dp;

public class No931WithIterator {
    public  int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int[][] dp = new int[n][n + 2];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = matrix[0][j - 1];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][n + 1] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = matrix[i][j - 1] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]);
            }
        }

        int res = dp[n - 1][1];
        for (int j = 1; j <= n; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }

        return res;
    }


     int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
