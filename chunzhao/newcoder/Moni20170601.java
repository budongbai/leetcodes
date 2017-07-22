package newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Moni20170601 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scan.nextInt();
        }
        Arrays.sort(h);
        int max = 0;
        for (int i = 2; i < n; i++) {
            max = Math.max(max, h[i] - h[i - 2]);
        }
        System.out.println(max);
        scan.close();
    }
}