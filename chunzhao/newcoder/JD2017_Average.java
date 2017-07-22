package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月6日下午9:06:05
 */
public class JD2017_Average {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            int sum = 0;
            for (int i = 2; i < num; i++) {
                int k = num;
                while (k > 0) {
                    sum += k % i;
                    k /= i;
                }

            }
            int m = num - 2;
            for (int i = 2; i <= m; i++) {
                if (sum % i == 0 && m % i == 0) {
                    sum = sum / i;
                    m = m / i;
                }
            }
            System.out.println(sum + "/" + m);
        }
        scan.close();
    }

}
