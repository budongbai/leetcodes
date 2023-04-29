package algorithm.leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月18日上午11:40:30
 */
public class L70 {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        System.out.println(Arrays.toString(memo));
        return climb_Stairs(0, n, memo);
    }

    public int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        // 如果已经计算过，那么直接返回结果，不必再递归求解
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        // System.out.println(Arrays.toString(memo));
        return memo[i];
    }

    // dp方法求解
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        L70 test = new L70();
        int res = test.climbStairs(44);
        System.out.println(res);

    }

}
