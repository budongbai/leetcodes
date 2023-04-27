package leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月15日上午9:46:19
 */
public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //但凡有个为0，则返回0
        if (m == 0 || n == 0)
            return 0;
        //如果Start或end位置的有路障，那么肯定为0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        dp[0][0] = 1;
        //对于第0行，如果有路障，则为0，否则为上一个元素的值
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = dp[0][i - 1];
        }
        //对于第0列，如果有路障，同行的处理一样
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i - 1][0];
        }
        //
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        if (rows < 1) return 0;
        int cols = obstacleGrid[0].length;
        if (cols < 1) return 0;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) return 0;

        int[] ans = new int[cols];
        ans[0] = 1;
        for (int j = 1; j < cols; j++) {
            if (obstacleGrid[0][j] == 0) {
                ans[j] = ans[j - 1];
            } else {
                ans[j] = 0;
            }
        }

        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                ans[0] = 0;
            }
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    ans[j] = 0;
                } else {
                    ans[j] += ans[j - 1];
                }
            }
        }

        return ans[cols - 1];
    }

    public static void main(String[] args) {
        L63 test = new L63();
        int[][] obstacleGrid = {{0, 0}, {0, 1}, {0, 0}};
        int res = test.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }
}
