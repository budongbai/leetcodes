package leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月12日下午3:26:40
 */
public class L55 {
    public boolean canJump(int[] nums) {
        //能到哪儿
        int reach = 0;
        int i = 0;
        //如果i小于他能到达的地方，并且i小于nums的长度，取reach的地方和第i个元素能到达的地方哪个更远
        for (; i < nums.length && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return (i == nums.length);

    }

    //从后往前
    public boolean canJump2(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return (last <= 0);
    }

    public static void main(String[] args) {
        L55 test = new L55();
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100000);
        }
        System.out.println(Arrays.toString(nums));
        long start = System.currentTimeMillis();
        System.out.println(test.canJump(nums));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(test.canJump2(nums));
        System.out.println(System.currentTimeMillis() - start);
    }
}
