package newcoder;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年6月16日下午6:54:04
 */
public class Moni20170602 {

    public static void main(String[] args) {

        int maxn = 500 + 5;
        double[][][] dp = new double[2][maxn][maxn];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   // 走的步数
        double ans = 0;
        dp[0][1][0] = 1.0;  // 第0步，有一个红格子，在第0个红格子上,的概率为1
        for (int i = 1; i <= n; i++) {
            int cur = i % 2;     // 0,1,0,1...
            int old = 1 - (i % 2);
            for (int j = 1; j <= i; j++)    // 现在是第n次，则第n-1次最多是有n个格子
                for (int k = 0; k < j; k++)
                    dp[cur][j][k] = 0;   // 前前次的结果设为0
            //
            for (int j = 1; j <= i; j++) {     // 第i步的红色格子数目至多为i个，？难道不是i+1？
                for (int k = 0; k < j; k++) {  // k表示现在在第k个格子上
                    if (dp[old][j][k] > 0) {
                        // 往右走
                        int pos1 = j;   // 现在有的格子数
                        int pos2 = k + 1; // 现在的位置是在k+1
                        if (pos1 == pos2)  // 走到了当前步数下的边界上了，也就是说假如现在j = 3， 而k+1已经到了第3个格子了，
                            ++pos1;     // 多一个空格？
                        dp[cur][pos1][pos2] += 0.5 * dp[old][j][k];//从上一个位置走到现在这个位置的概率为上一个位置的概率*0.5，
                        // 往左走
                        int pos3 = j;
                        int pos4 = k - 1;
                        if (pos4 == -1) {  // 边界条件，在位置-1的时候
                            pos3++;    // 格子数增加1
                            pos4++;    // 把-1的那个格子记为第0个格子~
                        }
                        dp[cur][pos3][pos4] += 0.5 * dp[old][j][k];
                    }
                }
            }
        }
        // 知道概率以后求期望
        for (int i = 1; i <= n + 1; i++) {   // 走n步，至多有n+1个格子
            for (int j = 0; j < i; j++) {  // 在第j个格子上
                ans += i * dp[n % 2][i][j];
                System.out.print(i + ", " + j + " : ");
                System.out.println(dp[n % 2][i][j]);
            }


        }
        DecimalFormat f = new DecimalFormat("0.0");
        System.out.print(f.format(ans));
    }

}
