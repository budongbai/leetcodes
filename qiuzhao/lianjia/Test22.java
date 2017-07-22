package lianjia;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月19日下午6:40:03
 */
public class Test22 {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int count = 0;
            int i = 0;
            for (i = 2; i <= Integer.MAX_VALUE; i++) {
                if (isPrime(i)) {
                    count++;
                }
                if (count == n) break;
            }
            System.out.println(i);

        }
        in.close();
    }

}
