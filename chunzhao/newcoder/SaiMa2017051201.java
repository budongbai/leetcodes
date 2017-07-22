package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年5月12日下午7:02:18
 */
public class SaiMa2017051201 {

    public static boolean isPrime(int num, int count) {
        int c = 1;
        for (int i = 2; i < num; i++) {
            if (huweizhishu(num, i)) {
                //System.out.print(i+" ");
                c++;
            }
        }
        return c == count ? true : false;
    }

    public static boolean huweizhishu(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        //辗转相除法
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b == 1;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int phi = scan.nextInt();
            int k = scan.nextInt();
            int i = 0;
            int j = 1;
            while (i < k) {
                boolean flag = isPrime(j, phi);
                if (flag) {
                    if (i == k - 1) {
                        System.out.println(j);
                    } else {
                        System.out.print(j + " ");
                    }
                    i++;
                }
                j++;
            }
        }
        scan.close();
    }

}
