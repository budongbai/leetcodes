package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月7日上午9:57:13
 */
public class L31 {
    public void nextPermutation(int[] nums) {
        int i, j;
        // 从后向前遍历数组，找到第一个非降序的下标
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        // 如果i等于0，说明没有非降序的序列，那最终结果应该是最小的排列，直接排一遍序完事
        if (i == 0) {
            Arrays.sort(nums);
        } else {
            // 再从后向前遍历数组，找到第一个比nums[i-1]大的数，将它们交换，并将i后面的数字反转
            for (j = nums.length - 1; j >= i; j--) {
                if (nums[i - 1] < nums[j]) {
                    break;
                }
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
            reverse(nums, i);
        }

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int i) {
        int start = i;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        L31 test = new L31();
        int[] nums = {1, 3, 2};
        test.nextPermutation(nums);
    }
}
