package lianjia;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月19日下午6:30:37
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] apples = new int[10];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = scan.nextInt();
        }
        int hth = scan.nextInt();
        int count = 0;
        for (int i = 0; i < apples.length; i++) {
            if (apples[i] - 30 <= hth) {
                count++;
            }
        }
        System.out.println(count);
        scan.close();
    }
}
