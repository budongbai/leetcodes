package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月14日下午7:45:35
 */
public class L5最长回文子串 {
    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        String sub = null;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {

            for (int j = i + 1; j <= len; j++) {
                String str = s.substring(i, j);
                if (isPalindrome(str) && str.length() > max) {
                    sub = str;
                    max = str.length();
                }
            }
        }
        return sub;
    }

    public boolean isPalindrome(String sub) {
        int len = sub.length();
        int i = 0;
        while (i <= len / 2) {
            if (sub.charAt(i) == sub.charAt(len - 1 - i)) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    private int lo, maxLen;

    /**
     * 中心扩展法，从中间的字母向外一一扩展，找最长回文子串。
     * 假设字符串是abba，那么i=1时，是从b和b开始对比的，如果字符串是aba，从b和自身开始对比的。
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i); // 确保奇数长度的子串, try to extend
            // Palindrome as possible
            extendPalindrome(s, i, i + 1); //偶数长度的子串
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为上一个循环多扩展了两个位置，所以这里边界是right - left - 1
        if (maxLen < right - left - 1) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }

    /**
     * dp解法
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome3(String s) {
        if (s.length() <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        // base case
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        // 最终需要返回子串，所以用left和max分别表示子串起始位置和长度
        int left = 0, max = 1;
        for (int curLength = 2; curLength <= s.length(); curLength++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + curLength - 1;

                if (j >= s.length()) {
                    break;
                }

                if (s.charAt(i) == s.charAt(j)) {
                    if (curLength <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && curLength > max) {
                        max = curLength;
                        left = i;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(left, left + max);
    }

    public static void main(String[] args) {
        String s = "aecbc";

        System.out.println(new L5最长回文子串().longestPalindrome(s));
    }
}
