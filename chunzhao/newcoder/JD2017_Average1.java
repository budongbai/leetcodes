package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月7日上午10:03:34
 */
public class JD2017_Average1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 2; i < n; i++) {
                int m = n;
                while (m > 0) {
                    sum += m % i;
                    m = m / i;
                }
            }
            int max = yue(sum, n - 2);
            System.out.println(sum / max + "/" + (n - 2) / max);
        }
        sc.close();
    }

    public static int yue(int m, int n) {
        while (m % n != 0) {
            int tmp = m;
            m = n;
            n = tmp % n;
        }
        return n;
    }

}
