package algorithm.leetcodes1_50;

import java.util.HashMap;

/**
 * @author budongbai
 * @version 2017年6月14日下午3:51:52
 */
public class L1TwoSum {

    public int[] twoSum(int[] nums, int target) {

        //int[] rs = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (map.containsKey(com)) {
                return new int[]{map.get(com), i};
            } else {
                map.put(nums[i], i);
            }

        }

        return null;
    }

    public static void main(String[] args) {


    }

}
