package datastructures.dp;

/**
 * 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。每次吹气球i可以得到的分数为 nums[left] * nums[i] *
 * nums[right]，left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。要求吹爆所有气球，得到最多的分数。
 * 注释: (1) 你可以假设nums[-1] = nums[n] = 1 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example: 给出[3, 1, 5, 8] 返回167。
 * <p>
 * 吹气球， 2016年谷歌笔试题，吹爆k气球，会使k-1气球和k+1相邻
 * 要吹爆i到j的气球，就要挑一个分数最大的气球k吹爆，然后分别吹i到k-1的气球和k+1到j的气球 状态转换方程dp[i][j] =
 * dp[i][k-1]+score(k)+dp[k+1][j];
 *
 * @author budongbai
 * @version 2017年5月14日下午8:46:28
 */
public class BlowBalloon {
    public static int maxCount(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[][] visited = new int[n + 2][n + 2];
        int[] arr = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n + 1] = 1;
        return search(arr, dp, visited, 1, n);
    }

    public static int search(int[] arr, int[][] dp, int[][] visited, int left, int right) {
        if (visited[left][right] == 1) {
            return dp[left][right];// 如果这个搜索已经进行过，直接返回结果
        }
        int res = 0;
        for (int k = left; k <= right; k++) {
            int midValue = arr[left - 1] * arr[k] * arr[right + 1];
            int leftValue = search(arr, dp, visited, left, k - 1);
            int rightValue = search(arr, dp, visited, k + 1, right);
            res = Math.max(res, leftValue + midValue + rightValue);
        }
        visited[left][right] = 1;
        dp[left][right] = res;
        return res;
    }

    public static void main(String[] args) {


        int[] nums = {4, 1, 5, 10};
        System.out.println(maxCount(nums));
        System.out.println(blowBalloon(nums));

    }

    public static int blowBalloon(int[] nums) {

        int[] nums2 = new int[nums.length + 2];
        for (int i = 1; i < nums.length + 1; i++) {
            nums2[i] = nums[i - 1];
        }
        nums2[0] = nums2[nums.length + 1] = 1;
        int n = nums2.length;
        int[][] dp = new int[n][n];
        for (int n_window = 2; n_window < n; ++n_window) {
            for (int left = 0; left < n - n_window; ++left) {
                int right = left + n_window;
                for (int n_middle = left + 1; n_middle < right; ++n_middle)
                    dp[left][right] = Math.max(dp[left][right],
                        nums2[left] * nums2[n_middle] * nums2[right] + dp[left][n_middle] + dp[n_middle][right]);
            }
        }

        return dp[0][n - 1];
    }

}
