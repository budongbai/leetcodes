package sjs;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年11月12日上午9:36:17
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] c = new int[n + 1];
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = scan.nextInt();
            a[i] = scan.nextInt();
            b[i] = scan.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= c[i]; k++) {
                    if (j - k * a[i] < 0) break;
                    f[j] = Math.max(f[j], f[j - k * a[i]] + b[i] * k);
                }
            }
        }
        System.out.println(f[m]);
    }
}
