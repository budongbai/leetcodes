package leetcodes51_100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月9日下午7:59:40
 */
public class L53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = Integer.MIN_VALUE;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i);
            }
            res = Math.max(res, nums[i]);

        }
        if (list.size() == 0) {
            return res;
        }
        if (list.size() == 1) {
            return nums[list.get(0)];
        }
        for (int i = 0; i < list.size() - 1; i++) {
            int start = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int end = list.get(j);
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += nums[k];
                }
                System.out.println(start + " " + end + " " + sum);
                res = Math.max(res, sum);
            }
        }

        return res;
    }

    public int maxSubArray2(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            //如果sum是负数，那么我们就抛弃他不要了，直接设置sum为当前元素
            if (sum < 0)
                sum = num;
            else
                //如果sum不是负数，那么我们就使用他累加。
                sum += num;
            if (sum > max)
                max = sum;
        }
        return max;
    }

    /**
     * 这个是典型的一维DP问题解法。
     *
     * @param nums
     * @return
     * @author budongbai
     * @version 2017年7月10日下午1:52:25
     */
    public int maxSubArray3(int[] nums) {
        int[] all = new int[nums.length];
        int[] start = new int[nums.length];
        all[nums.length - 1] = nums[nums.length - 1];
        start[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            start[i] = Math.max(nums[i], start[i + 1] + nums[i]);
            all[i] = Math.max(start[i], all[i + 1]);
        }
        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(all));
        return all[0];
    }

    /**
     * 根据上面的一维DP解法优化得到空间复杂度为O(1)。
     *
     * @param nums
     * @return
     * @author budongbai
     * @version 2017年7月10日下午1:53:30
     */
    public int maxSubArray4(int[] nums) {
        int nStart = nums[nums.length - 1];
        int nAll = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            nStart = Math.max(nums[i], nStart + nums[i]);
            nAll = Math.max(nStart, nAll);
        }
        return nAll;
    }

    public static void main(String[] args) {
        L53 test = new L53();
        int[] nums = {-3, 1, -2, 2};
        System.out.println(test.maxSubArray3(nums));
    }
}
