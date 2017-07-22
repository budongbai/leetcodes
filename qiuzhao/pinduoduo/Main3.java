package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月1日下午7:59:04
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        //小孩要求的重量
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scan.nextInt();
        }
        Arrays.sort(h);
        //巧克力的重量
        int m = scan.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = scan.nextInt();
        }
        Arrays.sort(w);
        //System.out.println(Arrays.toString(h)+ Arrays.toString(w));
        int count = 0;
        for (int i = n - 1, j = m - 1; i >= 0 && j >= 0; ) {
            if (h[i] > w[j]) {
                i--;
            } else {
                i--;
                j--;
                count++;
            }
        }
        System.out.println(count);
        scan.close();
    }
}
