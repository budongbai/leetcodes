package leetcodes1_50;

/**
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 *
 * @author budongbai
 * @version 2017年6月25日下午2:30:35
 */
public class L10正则表达式匹配 {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 空串和空串匹配成功
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            // 空串只能和x*匹配，当前字符j
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                // 第j个字符
                dp[0][j + 1] = true;
            }
        }

        /*
         * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
         * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
         * 3, If p.charAt(j) == '*':
         *    here are two sub conditions:
         *                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
         *                2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
         *                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
         *                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
         *                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // 普通的字符匹配上了或者有万能字符.
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    // 模式串中字符为*，可能存储没有匹配，匹配一个，匹配多个的情况
                    // 如果当前字符串前一个字符没有和模式串前2个字符匹配，且前2个字符不是万能字符，这个就没有匹配上
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        // p的x*没和s匹配上，跳过x*
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i][j + 1] // a* 匹配多个a
                            || dp[i + 1][j]             // a*匹配一个a
                            || dp[i + 1][j - 1];        // a* 没匹配
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        ////初始化第0行,除了[0][0]全为false，毋庸置疑，因为空串p只能匹配空串，其他都无能匹配
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = false;
        //只有p是X*，才与s匹配
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = j > 1 && '*' == p.charAt(j - 1) && dp[0][j - 2];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                //这里j-1才是正常字符串中的字符位置
                //要不*当空，要不就只有当前字符匹配了*之前的字符，才有资格传递dp[i-1][j]真值
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                else
                    //只有当前字符完全匹配，才有资格传递dp[i-1][j-1] 真值
                    dp[i][j] = (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) && dp[i - 1][j - 1];
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        L10正则表达式匹配 test = new L10正则表达式匹配();
        System.out.println(test.isMatch("aaabc", "a*bc"));
    }
}
