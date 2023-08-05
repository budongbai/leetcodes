package algorithm.leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * @author budongbai
 * @version 2017年7月9日下午7:48:51
 */
public class L40 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int[] num = {};

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        this.num = num;
        Arrays.sort(num);
        backTracking(new ArrayList<>(), 0, target);
        return ans;
    }

    public void backTracking(List<Integer> cur, int from, int tar) {
        if (tar == 0) {
            //查看该解是否已经在结果集中，如对于输入[1,1]和1，只需放一个[1]到结果集中  
            boolean exist = false;
            for (int i = ans.size() - 1; i >= 0; i--) {
                List<Integer> tmp = ans.get(i);
                //如果取得的list大小与当前链表大小不同，则取下一个
                if (tmp.size() != cur.size()) {
                    continue;
                }
                int j = 0;
                //一一对比
                while (j < cur.size() && Objects.equals(tmp.get(j), cur.get(j))) {
                    j++;
                }
                //对比结束，如果j与当前链表大小相等，则确实存在，不要再找了
                if (j == cur.size()) {
                    exist = true;
                    break;
                }
            }

            //如果当前解不在结果集中，把其加入到结果集中  
            if (!exist) {
                List<Integer> list = new ArrayList<>(cur);
                ans.add(list);
            }
            return;
        }
        for (int i = from; i < num.length && num[i] <= tar; i++) {
            cur.add(num[i]);
            //无重复元素，所以从下一个开始递归
            backTracking(cur, i + 1, tar - num[i]);
            cur.remove(Integer.valueOf(num[i]));
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        // 先进行排序
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return res;
    }

    public void backtrack(int start, int[] candidates, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝操作
        for (int i = start; i < candidates.length && sum + candidates[i] <= target; ++i) {
            // 去重，因为已经排过序了，且题目要求无重复元素。
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(i + 1, candidates, target);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
