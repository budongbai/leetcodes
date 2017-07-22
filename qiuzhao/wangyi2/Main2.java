package wangyi2;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月9日下午1:43:09
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int c4 = 0;
            int c2 = 0;
            int c = 0;
            int num;
            for (int j = 0; j < n; j++) {
                num = scan.nextInt();
                if (num % 2 == 0 && num % 4 != 0) {
                    c2++;
                } else if (num % 4 == 0) {
                    c4++;
                } else {
                    c++;
                }
            }
            // System.out.println(c4+"," + c2+ ", "+c);
            if (n - c2 == c4 * 2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            if (c2 == 0) {
                if (c4 >= c - 1)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            } else {
                if (c4 >= c)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }

        scan.close();
    }

}
