package toutiao1;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月23日下午12:23:42
 */
public class Main22 {
    public static long ans;
    public static long anss;

    public static void dfs(int[] a, int start, int end) {
        if (start > end) return;
        if (start == end) {
            long anss = a[start] * a[start];
            if (anss > ans) ans = anss;
            return;
        }
        long sum = 0;
        long minn = 1000000;
        int flag = -1;
        for (int i = start; i <= end; i++) {
            if (a[i] < minn) {
                minn = a[i];
                flag = i;
            }
            sum += a[i];
        }

        long anss = sum * minn;
        if (anss > ans) ans = anss;
        dfs(a, start, flag - 1);
        dfs(a, flag + 1, end);
        return;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int flag = -1;
        //其实就是遍历了一遍找到了最小值，计算了一下最小值×整个区间的乘积
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            sum += a[i];
            if (a[i] < min) {
                min = a[i];
                flag = i;
            }
        }
        ans = sum * min;
        //以当前区间最小值为界限进行划分，成了两个子区间，分别对两个子区间进行递归操作
        dfs(a, 0, flag - 1);
        dfs(a, flag + 1, n - 1);
        System.out.println(ans);
        scan.close();
    }

}
