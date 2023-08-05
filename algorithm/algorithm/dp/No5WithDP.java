

package algorithm.dp;

/**
 * 最长回文子序列
 *
 * dp问题说白了就是让计算机尽量少的枚举，将可以重复计算的子问题结果存储下来，遇到重复子问题时访问dp表来进行处理，以减少计算次数。
 * 迭代写法 VS 递归写法
 *
 * dp问题核心：
 * 1. base case：dp table初始化，枚举需要以base case初始化结果为基础进行扩散。
 * 2. 状态：dp[i][j]表示什么
 * 3. 选择：最长回文子序列这个题目的选择只有一个
 * 4. 转移：dp[i][j] = Function(dp[i-1]dp[j-1], dp[i][j-1], dp[i-1][j], dp[i+1][dp[j-1], ...)
 *
 * # 自顶向下递归的动态规划
 * def dp(状态1, 状态2, ...):
 *     for 选择 in 所有可能的选择:
 *         # 此时的状态已经因为做了选择而改变
 *         result = 求最值(result, dp(状态1, 状态2, ...))
 *     return result
 *
 * # 自底向上迭代的动态规划
 * # 初始化 base case
 * dp[0][0][...] = base case
 * # 进行状态转移
 * for 状态1 in 状态1的所有取值：
 *     for 状态2 in 状态2的所有取值：
 *         for ...
 *             dp[状态1][状态2][...] = 求最值(选择1，选择2...)
 */
public class No5WithDP {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        // dp[i][j] 表示s [i...j]子串是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // base case 长度为1的子串均为回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int left = 0, maxLength = 1;
        // 枚举子串长度，从2开始
        for (int curLength = 2; curLength <= s.length(); curLength++) {
            // 穷举[i,length + i -1]，开始判断每个子串是否回文串
            for (int i = 0; i < s.length(); i++) {
                // 当前长度
                int j = curLength + i - 1;
                if (j >= s.length()) {
                    break;
                }
                // i != j，非回文字符串
                // 状态转移方程 = dp[i][j]=dp[i+1]dp[j-1] (当s[i] = s[j])
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
