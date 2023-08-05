package algorithm.leetcodes101_150;

import java.util.Arrays;
import java.util.Comparator;

public class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        // 按照宽度升序排序，在宽度相同时，再将高度按降序排序，最后求高度数组的最长递增子序列。

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return  a[0] - b[0];
        });

        int[] nums = new int[envelopes.length];

        int i = 0;
        for (int[] a : envelopes) {
            nums[i] = a[1];
            i++;
        }
        return maxOfLIS(nums);
    }

    private int maxOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        L354 demo = new L354();
        demo.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
    }
}
