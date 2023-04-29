package algorithm.leetcodes101_150;

public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = nums.length + 1;

        int start = 0, end = 0;
        // 滑动窗口，双指针
        while (end < nums.length) {
            sum += nums[end];

            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return min == nums.length + 1 ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        L209 demo = new L209();
        System.out.println(demo.minSubArrayLen2(7, new int[]{1, 2, 3, 4,9}));

    }
}
