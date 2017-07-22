package union;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月20日下午2:34:52
 */
public class Main2 {
    private static int[] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();

        int index = 0;
        int[] weight = new int[N];// 重量
        int[] value = new int[N];// 价值
        int[] count = new int[N];// 数量
        while (index < N) {
            weight[index] = in.nextInt();
            value[index] = in.nextInt();
            count[index] = in.nextInt();
            index++;
        }

        dp = new int[W + 1];

        // 初值 dp[0][j]=0;
        for (int i = 1; i < N + 1; i++) {
            if (count[i - 1] * weight[i - 1] >= W) {// 相当于无限数量的第i中物品

                completePack(weight[i - 1], value[i - 1], W, i);
            } else {

                int m = count[i - 1];
                for (int k = 1; k <= m; ) {
                    zeroOnePack(k * weight[i - 1], k * value[i - 1], W, i);

                    m -= k;
                    k *= 2;
                }

                zeroOnePack(weight[i - 1] * m, value[i - 1] * m, W, i);
            }
        }
        System.out.println(dp[W]);
    }

    private static void zeroOnePack(int nweight, int nvalue, int W, int i) {

        for (int j = W; j >= nweight; j--) {
            dp[j] = Math.max(dp[j - nweight] + nvalue, dp[j]);
        }

    }

    private static void completePack(int nweight, int nvalue, int W, int i) {
        for (int j = nweight; j <= W; j++) {
            dp[j] = Math.max(dp[j - nweight] + nvalue, dp[j]);
        }
    }

}
