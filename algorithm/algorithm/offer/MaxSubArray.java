package algorithm.offer;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int last = 0;

        for (int num : nums) {
            if (last < 0) {
                last = num;
            } else {
                last = last + num;
            }

            if (last > max) {
                max = last;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-1};

        System.out.println(new MaxSubArray().maxSubArray(array));
    }
}
