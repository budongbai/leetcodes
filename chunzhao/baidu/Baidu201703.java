package baidu;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月27日下午6:43:56
 */
public class Baidu201703 {

    public static void satisfy(int n) {

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = 5;

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {

                System.out.print(j);

            }
            System.out.println();
        }
        scan.close();
    }

}
