package leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月21日下午8:27:32
 */
public class L75 {
    //双轴排序，
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int p2 = nums.length - 1;
        int p0 = 0;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;//这里应该加一个i--，因为2与i位置交换的值可能是0啊
                i--;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }

    }

    public static void main(String[] args) {
        L75 test = new L75();
        int[] nums = {0, 1, 2, 1, 2, 0, 1, 1, 2, 2, 1, 0, 1};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
