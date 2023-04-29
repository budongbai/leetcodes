package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月5日上午11:06:52
 */
public class L27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
                length--;
            }
            i++;
        }
        Arrays.sort(nums);
        return length;
    }

    public int removeElement2(int[] nums, int val) {
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[m] = nums[i];
                m++;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5};
        L27 test = new L27();
        System.out.println(test.removeElement2(nums, 5));

        System.out.println(Arrays.toString(nums));
    }
}
