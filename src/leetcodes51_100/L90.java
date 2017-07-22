package leetcodes51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年8月7日下午10:16:36
 */
public class L90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);

            if (tmp.size() == tempList.size()) {
                int count = 0;
                for (int j = 0; j < tmp.size(); j++) {
                    if (tmp.get(j).equals(tempList.get(j))) {
                        count++;
                    }
                }
                if (count == tmp.size()) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    //直接移除了重复的，不用在加入总链表时判断。
    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {
                i++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        L90 test = new L90();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = test.subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
