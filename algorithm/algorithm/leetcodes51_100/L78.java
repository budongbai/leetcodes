package algorithm.leetcodes51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月24日下午5:11:10
 */
public class L78 {
    //位操作法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int size = (int) Math.pow(2, nums.length);
        for (int i = 0; i < size; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            int j = i, count = 0;
            while (j > 0) {
                if ((j & 1) == 1) {
                    tmp.add(nums[count]);
                }
                j >>= 1;
                count++;
            }
            res.add(tmp);
        }
        return res;
    }

    //递归解法
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        L78 test = new L78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = test.subsets(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
