package algorithm.leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月11日上午11:57:12
 */
public class L47 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] num = {};

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.num = nums;
        Arrays.sort(num);
        boolean[] used = new boolean[nums.length];

        backTracking(new ArrayList<Integer>(), used);

        return res;
    }

    public void backTracking(List<Integer> cur, boolean[] used) {
        if (cur.size() == num.length) {
            res.add(new ArrayList<Integer>(cur));

            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i])
                continue;
            //如果当前元素与前一元素相等，并且前一个元素未被使用，则跳过当前元素，不对此元素进行递归操作
            if (i > 0 && num[i - 1] == num[i] && !used[i - 1])
                continue;
            used[i] = true;
            cur.add(num[i]);
            backTracking(cur, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        L47 test = new L47();
        int[] nums = {2, 2, 1, 1};
        List<List<Integer>> list = test.permuteUnique(nums);
        for (List<Integer> li : list) {
            System.out.println(li);
        }
    }

}
