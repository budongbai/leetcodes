package didi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月22日下午6:56:48
 */
public class DiDi201702 {

    public static void sort(int[] a, int[] a2) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    temp = a2[j];
                    a2[j] = a2[j + 1];
                    a2[j + 1] = temp;
                } else if (a[j] == a[j + 1]) {
                    if (a2[j] > a2[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                        temp = a2[j];
                        a2[j] = a2[j + 1];
                        a2[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] widths = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            widths[i] = scan.nextInt();
            heights[i] = scan.nextInt();
        }
        sort(widths, heights);
        int count = 1;
        int lastw = widths[0];
        int lasth = heights[0];
        for (int i = 1; i < widths.length; i++) {
            //如果宽和高都小于下面的宽和高
            if (lastw < widths[i] && lasth < heights[i]) {
                count++;
                lastw = widths[i];
                lasth = heights[i];
            }
        }
        System.out.println(count);
        scan.close();
    }

}
