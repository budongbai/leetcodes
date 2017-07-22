package wacai;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年10月12日下午6:57:57
 */
public class Main1 {
    public static int countDecoding(String str) {
        int len = str.length();
        char[] s = str.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s[1] == '0') dp[1] = 0;
        else dp[1] = 1;
        for (int i = 2; i <= len; ++i) {
            if (s[i] == '0' && (s[i - 1] > '2' || s[i - 1] == '0')) continue;
            int x = (s[i - 1] - '0') * 10 + s[i] - '0';
            if (x == 10 || x == 20) {
                dp[i] = dp[i - 2];
            } else if (x < 10 || x > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(countDecoding(s));
        scan.close();
    }
}
