package newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年5月19日下午6:58:50
 */
public class NowCoder02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[3 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        int result = 0;
        for (int i = n; i < 3 * n; i = i + 2) {
            result += arr[i];
            System.out.print(i + "\t");
        }
        System.out.println();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr[n + 2 * i];
            System.out.print(n + 2 * i + "\t");
        }

        System.out.println(ans);
        System.out.println(result);
        scan.close();

    }

}
