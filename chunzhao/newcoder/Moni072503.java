package newcoder;

import java.util.Scanner;

/**
 * 作者：NotDeep
 * 链接：https://www.nowcoder.com/discuss/30055?type=0&order=0&pos=5&page=1 来源：牛客网
 * <p>
 * 仔细分析我们可以发现一个位置是Y还是N依赖于他的倍数。考虑若干个素数p0,p1,p2...p3,当他们的乘积那个数确定为Y,那么它们一定也是Y。
 * 例如：如果27是Y,那么9一定是Y,3也一定是Y,但是81可以是Y或者N。
 * 由于每个数都可以分解为若干素数的乘积。于是我们考虑范围内的素数及其k次幂的位置的情况,其他数字都可以由这些组合而来。例如：n = 64
 * 考虑2的次幂：如果64是Y,那么32 16 8 4 2都要是Y;如果64是N,32是Y,16 8 4 2都要是Y;如果64 32是N，16是Y，8 4
 * 2都要是Y;...依次类推一共有7种情况(因为64 = 2^6)那么问题就变成计算每个素数p_i^(maxexp) <=
 * n,然后情况数就是每个(maxexp + 1)的乘积
 *
 * @author budongbai
 * @version 2017年7月25日下午7:54:50
 */
public class Moni072503 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int maxn = 1000005;
        int mod = 1000000007;
        int[] vis = new int[maxn];
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            if (vis[i] != 0)
                continue;
            for (int j = i + i; j <= n; j += i)
                vis[j] = 1;
            int tmp = n, cnt = 0;
            while (tmp >= i) {
                tmp /= i;
                cnt++;
            }
            ans = ans * (cnt + 1) % mod;
        }
        System.out.println(ans);
        scan.close();

    }

}
