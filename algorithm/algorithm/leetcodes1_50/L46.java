package algorithm.leetcodes1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月10日下午9:07:14
 */
public class L46 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] num = {};

    public List<List<Integer>> permute(int[] nums) {
        this.num = nums;
        boolean[] used = new boolean[nums.length];
        backTracking(new ArrayList<>(), used);
        return res;
    }

    public void backTracking(List<Integer> cur, boolean[] used) {
        if (cur.size() == num.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                used[i] = true;
                cur.add(num[i]);
                backTracking(cur, used);
                cur.remove(Integer.valueOf(num[i]));
                used[i] = false;
            }
        }
    }

    // 迭代的做法
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();
            for (List<Integer> cur : res) {
                for (int j = 0; j < cur.size() + 1; j++) {
                    //把第i个元素一一加入到原有链表中的各子链表中的各个位置，比如链表中只有一个含有元素1的子链表，这时我们要加入2，所以就能得到1,2和2,1.
                    List<Integer> item = new ArrayList<>(cur);
                    item.add(j, nums[i]);
                    newRes.add(item);
                }
            }
            res = newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        L46 test = new L46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = test.permute(nums);
        for (List<Integer> li : list) {
            System.out.println(li);
        }
    }
}
