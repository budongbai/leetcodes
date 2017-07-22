package qiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年5月14日下午8:00:13
 */
public class QiYi01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String s = scan.nextLine();
		String[] ss = s.split("\\s+");
		int[] p = new int[(ss.length - 1) / 2];
		int[] v = new int[(ss.length - 1) / 2];
		int totalP = Integer.parseInt(ss[0]);
		for (int i = 0; i < p.length; i++) {
			p[i] = Integer.parseInt(ss[2 * i + 1]);
			v[i] = Integer.parseInt(ss[2 * i + 2]);
		}
		System.out.println(Arrays.toString(p) + Arrays.toString(v));
		System.out.println(KnapSack(p.length, p, v, totalP));
		// 10 5 7 2 3 8 10 3 4
		int[][] sss = new int[5][3];
		System.out.println(sss.length);
		// System.out.println(max);
		scan.close();

	}

	public static int KnapSack(int n, int p[], int v[], int C) {
		int[][] dp = new int[n + 1][C + 1];
		int i, j;
		for (i = 0; i <= n; i++)
			dp[i][0] = 0;
		for (j = 0; j <= C; j++)
			dp[0][j] = 0;
		for (i = 1; i <= n; i++)
			for (j = 1; j <= C; j++)
				if (j < p[i - 1])
					dp[i][j] = dp[i - 1][j];
				else
					// 第i个物品放进去的最大价值等于前i-1个物品放背包的最大价值加上当前物品的价值，为啥是v[i-1]这里的循环的i比数组pv早一个,循环i对应的pv应该是i-1.
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p[i - 1]] + v[i - 1]);

		for (i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[n][C];

	}
}
