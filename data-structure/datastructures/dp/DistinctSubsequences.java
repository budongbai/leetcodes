package datastructures.dp;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S. A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters without
 * disturbing the relative positions of the remaining characters. (ie,"ACE"is a
 * subsequence of"ABCDE"while"AEC"is not). Here is an example: S ="rabbbit", T
 * ="rabbit" Return3.
 *
 * @author budongbai
 * @version 2017年5月14日下午12:32:49
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }
        if (S.length() < T.length()) {
            return 0;
        }
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= T.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences d = new DistinctSubsequences();
        System.out.println(d.numDistinct("rabbbit", "rabbit"));
    }
}
