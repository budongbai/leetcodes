package pinduoduo;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月1日下午7:58:33
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int num;
        for (int i = 0; i < n; i++) {
            num = scan.nextInt();
            if (num > max) {
                max3 = max2;
                max2 = max;
                max = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min) {
                min2 = min;
                min = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        long pr1 = max2 * max3;
        long pr2 = min * min2;
        // long res = pr1 > pr2 ?pr1 : pr2;

        System.out.println(pr1 > pr2 ? pr1 * max : pr2 * max);

        scan.close();
    }
}
