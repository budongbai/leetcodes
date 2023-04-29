package algorithm.leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月14日下午3:04:17
 */
public class L62 {
    // 数学解法等于C(m-1,(m+n-2))

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        m--;
        n--;
        if (m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) { // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
        return (int) res;
    }

    //动态规划实现，二维数组
    public int uniquePaths2(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        for (int i = 0; i < m; i++)
            System.out.println(Arrays.toString(grid[i]));
        return grid[m - 1][n - 1];
    }

    //动态规划实现，一维数组
    public int uniquePaths3(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }

            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        L62 test = new L62();
        int res = test.uniquePaths3(3, 7);
        System.out.println(res);
    }

}
