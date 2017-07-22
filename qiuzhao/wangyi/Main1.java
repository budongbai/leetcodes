package wangyi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月12日下午2:42:44
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int f = scan.nextInt();
        int d = scan.nextInt();
        int p = scan.nextInt();
        int tmp1 = d / x;
        //就因为这里！！！
        if (tmp1 <= f) {
            System.out.println(tmp1);
        } else {
            d -= f * x;
            System.out.println(f + d / (x + p));
        }
        scan.close();
    }
}
