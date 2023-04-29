package algorithm.leetcodes51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月22日上午8:22:21
 */
public class L77 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    //我写的是多次调用rec，而方法2只调用了一次，其实不用多次rec调用,可以被注释掉
    public List<List<Integer>> combine(int n, int k) {
		/*for (int i = 1; i <= n - k + 1; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			rec(list, i + 1, n, k);
		}*/
        List<Integer> list = new ArrayList<Integer>();
        rec(list, 1, n, k);
        return res;
    }

    public void rec(List<Integer> list, int start, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        // 添加
        for (int i = start; i <= n; i++) {
            list.add(i);
            rec(list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    //另一种解法C(n,k)=C(n-1,k-1)+C(n-1,k)
    public List<List<Integer>> combine3(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        //Lambda表达式
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }
}
