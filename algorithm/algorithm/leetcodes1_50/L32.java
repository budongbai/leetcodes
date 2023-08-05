package algorithm.leetcodes1_50;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/longest-valid-parentheses/description/">32. 最长有效括号</a>
 * 困难
 * 2.3K
 * 相关企业
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 */
public class L32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        // 栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - stack.peek(), max);
                }
            }
        }
        return max;
    }

    // ( ) ( ) ( ( ) )
    // 0 1 2 3 4 5 6 7
    // 0 2 0 4 0 0 2 8
    public int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }

                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}