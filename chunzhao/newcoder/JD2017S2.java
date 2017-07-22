package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月7日下午8:23:33
 */
public class JD2017S2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            int sum = n;
            boolean flag = true;
            int i = 0;


            while (sum > k) {
                if (flag) {
                    sum = sum - k;
                    i++;
                    flag = false;
                } else {
                    sum = sum - 1 - k;
                    flag = true;
                    i++;
                }
            }
            System.out.println(i);
        }
        scan.close();
    }

}
