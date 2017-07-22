package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年5月19日下午6:58:50
 */
public class NowCoder03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = scan.nextInt();
            array[i][1] = scan.nextInt();
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        scan.close();
    }

}
