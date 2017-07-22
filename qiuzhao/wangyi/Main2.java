package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月12日下午2:42:44
 * <p>
 * 1
 * 1 1
 * 1
 * 有可能是这种，大家都往中间那个位置走
 * 关键在于，最后堆棋子的那个格子，横纵坐标必然在棋子初始的横纵坐标中间
 * 用反证法，xy轴其实是独立的，先只考虑x坐标，假设把k个棋子堆到x0格子所用的步骤最少，
 * a个棋子初始在x0的左边，b个棋子初始在x0的右边，且a>b,那么必然存在横坐标为x0-1的格
 * 子，这k个棋子到x0-1的步数会更少，b>a的情况，那么x0+1的目标将比x0更优，至于a=b， x0-1
 * 和x0的步数是一样的。因此，最终汇聚棋子的x坐标只要在棋子初始的x个坐标中考虑
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = scan.nextInt();
        }
        long[] res = new long[n];
        Arrays.fill(res, Long.MAX_VALUE);
        res[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int[] res2 = new int[n];
                    for (int l = 0; l < n; l++) {
                        //计算有棋子的格子的坐标 到棋盘上的其他所有格子的距离， jk对应的就是棋盘上所有的点
                        res2[l] = Math.abs(x[l] - x[j]) + Math.abs(y[l] - y[k]);
                    }
                    Arrays.sort(res2);
                    int res3 = 0;
                    //i用来计算 i个棋子移动到一个格子，
                    for (int l = 0; l < i + 1; l++)
                        res3 += res2[l];
                    res[i] = Math.min(res[i], res3);
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[n - 1]);
        scan.close();
    }
}
