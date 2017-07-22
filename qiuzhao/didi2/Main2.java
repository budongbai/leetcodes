package didi2;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月10日下午4:10:09
 */
public class Main2 {
    public static int min(int a, int b, int c) {
        int min = (a < b ? a : b);
        return min < c ? min : c;
    }

    public static int findChoushu(int number) {
        int index = 0;
        int[] num = new int[number];
        num[0] = 1;  //先初始化;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int minChoushu = 0;
        while (index < number - 1) {
            minChoushu = min(num[index2] * 2, num[index3] * 3, num[index5] * 5);
            if (minChoushu == num[index2] * 2) {
                index2++;
            }
            if (minChoushu == num[index3] * 3) {
                index3++;
            }
            if (minChoushu == num[index5] * 5) {
                index5++;
            }
            num[++index] = minChoushu;

        }
        return num[num.length - 1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(findChoushu(n));
        scan.close();
    }

}
