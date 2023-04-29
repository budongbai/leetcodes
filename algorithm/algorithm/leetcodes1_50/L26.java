package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月4日下午9:34:32
 */
public class L26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }
        int length = 1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                length++;
            } else {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return length;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    public static void main(String[] args) {
        L26 test = new L26();
        int[] nums = {1, 1, 2};
        test.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
