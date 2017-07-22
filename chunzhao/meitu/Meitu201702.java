package meitu;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月16日下午7:36:10
 * 无论这个数是多少，如果我能给对方留下四个石头，那我就稳赢
 */
public class Meitu201702 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int str = scan.nextInt();
            System.out.println(str % 4 != 0);
        }
        scan.close();
    }

}
