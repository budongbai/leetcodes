package jd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author budongbai
 * @version 2017年9月8日下午8:21:44
 */
public class Main2 {

    public final static long MOD = 1000000007;

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static long gcd(long a, long b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long ans = (long) 1 * n * (n * 2 - 1) % MOD;
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            if (set.contains(i))
                continue;
            long tmp = i;
            int cnt = 0;

            while (tmp <= n) {
                set.add((int) tmp);
                tmp = tmp * i;
                cnt++;
            }

            for (int k = 1; k <= cnt; k++) {
                for (int j = k + 1; j <= cnt; j++) {
                    ans = (ans + n / (j / gcd(k, j)) * (long) 2) % MOD;
                }
            }

        }

        System.out.println(ans);
    }

}
