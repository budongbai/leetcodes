package algorithm.leetcodes1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月4日下午4:13:47
 */
public class L22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        generate(n, n, s, list);
        return list;
    }

    private void generate(int leftNum, int rightNum, String s, List<String> result) {
        //当左右值为0时，得到一个合法排列
        if (leftNum == 0 && rightNum == 0) {
            result.add(s);
        }
        //如果左值大于0，则可以继续打印左括号
        if (leftNum > 0) {
            generate(leftNum - 1, rightNum, s + '(', result);
        }
        //如果右值大于0并且左值小于右值，只能打印右括号
        if (rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum - 1, s + ')', result);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        L22 test = new L22();
        List<String> list = test.generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }


    }
}
