package qunar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月14日上午9:23:28
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long k = scan.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        //Arrays.sort(nums);
        List<List<Integer>> res;
        List<Integer> ans = null;
        for (int i = 1; i <= n; i++) {
            res = combine(n, i);
            for (int j = 0; j < res.size(); j++) {
                List<Integer> list = res.get(j);
                long sum = 0;
                for (int l = 0; l < list.size(); l++) {
                    sum += nums[list.get(l) - 1];
                }
                if (sum == k) {
                    ans = list;
                    break;
                }
            }
            if (ans != null) {
                break;
            }
        }
        if (ans != null) {
            System.out.println("YES");
            for (int i = 0; i < ans.size(); i++) {
                if (i == ans.size() - 1) {
                    System.out.println(nums[ans.get(i) - 1]);
                } else {
                    System.out.print(nums[ans.get(i) - 1] + " ");
                }

            }
        } else {
            System.out.println("NO");
        }

        scan.close();
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = combine(n - 1, k - 1);
        //Lambda表达式
        result.forEach(e -> e.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }
}
