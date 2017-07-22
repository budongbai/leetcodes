package newcoder;

import java.util.Scanner;

/**
 * 炮是中国象棋中的一种棋子。炮吃子的规则为：被吃棋子与炮之间需要隔一个棋子。
 * 假设在n×m的矩形方格中可摆放任意个数字的棋子（任意个数包含0，即可以不放棋子）， 使各个炮互不吃到的情况下方案数有几种。 输入
 * 两个正整数n和m，中间以空格隔开，分别表示棋盘方格的长和宽。 输出 一个正整数q，表示符合情况的方案数（q<10^9）
 * <p>
 * 样例输入 1 3 样例输出 7
 * <p>
 * Hint 【数据范围】 对于40%的数据,n<=4,m<=4 对于70%的数据,n<=100,m<=8 对于100%的数据,n<=100,m<=100
 *
 * @author budongbai
 * @version 2017年5月12日下午7:02:18
 */
public class SaiMa2017051202 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            /*
             * int sum = 1+ n*m;//不放棋子或放一个 int p =n *m ; sum+=
             * p*(p-1)/2;//放两个，不管是挨着放还是隔着放，只要隔着1个放的时候中间不放棋子，或者隔着两个以上放两个以上棋子都满足条件
             * System.out.println(sum);
             */

            long mod = 999983;
            long f[][][] = new long[105][105][105];
            f[0][0][0] = 1;
            for (int i = 1; i <= n; i++)
                for (int j = 0; j <= m; j++)
                    for (int k = 0; j + k <= m; k++) {
                        f[i][j][k] = f[i - 1][j][k];
                        f[i][j][k] %= mod;// 不放
                        if (j >= 1)
                            f[i][j][k] += f[i - 1][j - 1][k] * (m - j - k + 1);
                        f[i][j][k] %= mod;// 空处放1个
                        if (k >= 1)
                            f[i][j][k] += f[i - 1][j + 1][k - 1] * (j + 1);
                        f[i][j][k] %= mod;// 1个处放1个
                        if (j >= 2)
                            f[i][j][k] += f[i - 1][j - 2][k] * (m - j - k + 2) * (m - j - k + 1) / 2;
                        f[i][j][k] %= mod;// 空处放2个
                        if (k >= 2)
                            f[i][j][k] += f[i - 1][j + 2][k - 2] * (j + 2) * (j + 1) / 2;
                        f[i][j][k] %= mod;// 1处放2个
                        if (k >= 1)
                            f[i][j][k] += f[i - 1][j][k - 1] * j * (m - j - k + 1);
                        f[i][j][k] %= mod;// 空处和1个处
                    }
            long ans = 0;
            for (int j = 0; j <= m; j++)
                for (int k = 0; j + k <= m; k++)
                    ans += f[n][j][k] %= mod;
            System.out.println(ans);
        }
        scan.close();

    }

}
