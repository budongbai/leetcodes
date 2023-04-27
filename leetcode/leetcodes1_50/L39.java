package leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月9日下午6:38:25
 */
public class L39 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int[] cans = {};

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cans = candidates;
        Arrays.sort(cans);
        // 回溯
        backTracking(new ArrayList<>(), 0, target);
        return ans;
    }

    public void backTracking(List<Integer> cur, int from, int target) {
        // target 等于0 说明已经凑完了，可以加入到结果了
        if (target == 0) {
            List<Integer> list = new ArrayList<>(cur);
            ans.add(list);
        } else {
            // 遍历加元素
            for (int i = from; i < cans.length && cans[i] <= target; i++) {
                //加入当前元素，递归
                cur.add(cans[i]);
                // 加完cans[i]， 下一步要凑target - cans[i]
                backTracking(cur, i, target - cans[i]);
                //完事后移除当前元素，这里要转成Integer，否则会匹配到remove(int )方法，移除某个位置的元素，而不是某个数字
                cur.remove(new Integer(cans[i]));
            }
        }
    }

    public static void main(String[] args) {
        L39 test = new L39();
        int[] nums = {2, 3, 6, 7};
        System.out.println(test.combinationSum(nums, 7));
    }
}
