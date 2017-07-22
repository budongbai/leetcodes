package qihu360;

import java.util.Scanner;

/**
 * 一年一度的跳水比赛又开始了，全国各地的运动员都纷纷报名参加了比赛。在比赛之前，举办方让运动员抽签决定了比赛的出场顺序，运动员会根据这个顺序依次出场，完成自己的动作，然后裁判评分。
 * 为了做好充分的准备和调整赛前心态，运动员希望了解其他运动员的实力，希望知道在自己出场之前，有多少位运动员上赛季的得分是高于自己的。现在你是一位数据分析家，你可以告诉运动员他们的情况么？
 * 输入
 * 第一行一个整数n，1≤n≤200000，
 * 第二行n个整数，第i个整数表示本次比赛第i个出场的运动员上赛季的得分ai，1≤ai≤200000。
 * 输出
 * 一行输出n个整数，第i个整数表示本次比赛在第i个出场的运动员之前出场且得分比其高的运动员个数。不要在行末输出多余的空格。
 * <p>
 * 样例输入
 * 5
 * 4 5 1 3 2
 * 样例输出
 * 0 0 2 2 3
 *
 * @author budongbai
 * @version 2017年8月26日下午6:55:23
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    num++;
                }
            }
            if (i == n - 1) {
                System.out.println(num);
            } else {
                System.out.print(num + " ");
            }
        }

        scan.close();
    }
}
