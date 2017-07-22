

package com.budongbai.leetcode.algorithm.dp;

/**
 * 最长回文子序列
 */
public class No5WithDP {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int left = 0, maxLength = 1;
        for (int curLength = 2; curLength <= s.length(); curLength++) {
            for (int i = 0; i < s.length(); i++) {
                int j = curLength + i - 1;
                if (j >= s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (curLength <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }
                if (dp[i][j] && curLength > maxLength) {
                    left = i;
                    maxLength = curLength;
                }
            }
        }

        return s.substring(left, left + maxLength);

    }


    public static void main(String[] args) {
        String test = "cbbd";
        No5WithDP no5 = new No5WithDP();
        System.out.println(no5.longestPalindrome(test));
    }
}
