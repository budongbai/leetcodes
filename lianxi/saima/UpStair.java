package saima;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月22日下午12:23:42
 */
public class UpStair {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }

        int[] dp = new int[n];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 2) {
                dp[i] = 1;
            } else {
                int[] tmp = new int[arr[i]];
                tmp[0] = 1;
                tmp[1] = 1;
                for (int j = 2; j < arr[i]; j++) {
                    tmp[j] = tmp[j - 1] + tmp[j - 2];
                }
                dp[i] = tmp[arr[i] - 1];
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(dp[i]);
        }

        scan.close();


    }

}
