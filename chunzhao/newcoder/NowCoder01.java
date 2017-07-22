package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年5月19日下午6:58:50
 */
public class NowCoder01 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[] A = new int[arr.length];
        int[] B = new int[arr.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = 1;
            B[i] = 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] >= arr[i]) {
                A[i + 1] = A[i] + 1;
            }
            if (arr[i + 1] <= arr[i]) {
                B[i + 1] = B[i] + 1;
            }
        }
        int count = 0;
        for (int i = A.length - 1; i >= 0; ) {
            if (A[i] > B[i]) {
                i = i - A[i];
            } else {
                i = i - B[i];
            }
            count++;
        }
        System.out.println(count);
        scan.close();
    }

}