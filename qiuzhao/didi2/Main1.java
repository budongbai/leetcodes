package didi2;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月10日下午2:43:09
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }
        int count = 0;
        int i = 0;
        while (i < n) {
            if (num[i] != 0) {
                if (i + 1 < n && num[i] == num[i + 1]) {
                    count++;
                    i += 2;
                } else {
                    count++;
                    i++;
                }
            }
        }
        System.out.println(count);
        scan.close();
    }

}
