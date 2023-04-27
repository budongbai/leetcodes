

package com.budongbai.leetcode.algorithm.dp;

/**
 * 最长回文子序列
 */
public class No5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0, end = 1;
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (isPalindrome(s, i, j) && (j - i) > end - start) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end);
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (end - start == 1) {
            return true;
        }
        int i = start, j = end - 1;
        boolean res = true;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            res = false;
            break;
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "bbabb";
        No5 no5 = new No5();
        System.out.println(no5.longestPalindrome(test));
    }
}
