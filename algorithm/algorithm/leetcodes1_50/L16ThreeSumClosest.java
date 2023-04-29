package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年6月29日下午7:37:08
 */
public class L16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1, -15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9, 0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10, 1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7, 0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6};
        System.out.println(new L16ThreeSumClosest().threeSumClosest(arr, -59));
        int[] arr2 = {0, 1, 2};
        System.out.println(new L16ThreeSumClosest().threeSumClosest(arr2, 0));
        int[] arr3 = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(new L16ThreeSumClosest().threeSumClosest(arr3, 82));

    }
}
