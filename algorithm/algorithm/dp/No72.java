package algorithm.dp;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/">72. 编辑距离</a>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class No72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示 word1前i个字符、word2前j个字符的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];
        // base case
        // 第一列，是 word2 为空，需要的最少步数，就是删除操作
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // 第一行，是 word1 为空变成 word2 最少步数，就是插入操作
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i - 1][j] + 1,// 删除操作，word1[0,i-1]、word2[0,j]匹配，多出了word1 i位置字符，删除操作后两者相同，操作距离+1
                                    dp[i][j - 1] + 1 // 插入操作，word1[0,i]、word2[0,j-1]匹配，word2多出了j位置字符，word1插入相同字符，操作距离+1
                            ),
                            dp[i - 1][j - 1] + 1 // 替换操作，word1[0,i-1]与word2[0,j-1]匹配，仅i与j不匹配，替换操作后两者相同，操作距离+1
                    );
                }
            }
        }
        return dp[m][n];
    }
}
