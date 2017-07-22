package wangyi2;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月9日下午1:43:09
 */
public class Main1 {

    public static int getReverseInt(int num) {
        int res = 0;
        int tmp = 0;
        while (num > 0) {
            tmp = num % 10;
            num = num / 10;
            res = res * 10 + tmp;
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int res = num + getReverseInt(num);
        System.out.println(res);

        scan.close();
    }

}
