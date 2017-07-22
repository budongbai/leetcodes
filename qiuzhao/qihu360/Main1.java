package qihu360;

import java.util.Scanner;

/**
 * 小明一共有n根彩色粉笔，m根白色粉笔，现在可以用a根彩色粉笔和b根白色粉笔组成一盒卖x元，
 * 或者c根白色粉笔组成一盒卖y元，或者d根彩色粉笔组成一盒卖z元，小明最多可以用这些粉笔卖多少元？
 * 不一定要把所有粉笔卖完，小明只希望利益最大化。
 * 输入
 * 第一行2个整数n，m，1≤n,m≤2000；
 * 第二行4个整数a，b，c，d，1≤a,b,c,d≤1000；
 * 第三行3个整数x，y，z，1≤x,y,z≤1000。
 * 输出
 * 输出一个整数，表示最多可以卖到多少元。
 * <p>
 * 样例输入
 * 5 5
 * 1 2 3 3
 * 2 1 3
 * 样例输出
 * 7
 * <p>
 * Hint
 * 补充样例：
 * 输入样例：
 * 5 15
 * 1 2 3 6
 * 2 1 3
 * 输出样例：
 * 11
 *
 * @author budongbai
 * @version 2017年8月26日下午6:55:23
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        int i = 0;
        int res = 0;
        while (i * a <= n && i * b <= m) {
            int temp = 0;
            temp += i * x;
            temp += (n - i * a) / d * z;
            temp += (m - i * b) / c * y;
            if (temp > res) {
                res = temp;
            }
            i++;
        }
        System.out.println(res);
        scan.close();
    }
}
