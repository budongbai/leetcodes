package pinduoduo;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月1日下午7:58:58
 */
public class Main2 {
    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length();
        int n2 = num2.length();
        int[][] dp = new int[n1 + 2][n2 + 2];
        int jinwei = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            int bit1 = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int bit2 = num2.charAt(j) - '0';
                int mul = bit1 * bit2 + jinwei + dp[i + 2][j];
                dp[i + 1][j + 1] = mul % 10;
                jinwei = mul / 10;
            }
            dp[i + 1][0] = jinwei;
            jinwei = 0;
        }
        boolean start = true;
        for (int i = 0; i <= n2; i++) {
            if (dp[1][i] == 0 && start) {

            } else {
                sb.append(dp[1][i]);
                start = false;
            }
        }
        for (int i = 2; i <= n1; i++) {
            sb.append(dp[i][n2]);
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        System.out.println(multiply(str1, str2));
        scan.close();
    }
}
