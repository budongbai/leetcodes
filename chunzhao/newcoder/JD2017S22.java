package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月7日下午8:23:33
 */
public class JD2017S22 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int i = n / (k + 1);
            if (k == 1) {
                System.out.println(i + n % (k + 1));

            } else {
                System.out.println(i);

            }

        }
        scan.close();
    }

}
