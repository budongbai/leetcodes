package sohu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月17日下午6:54:47
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            sum += nums[i];
        }

        int[] rn = new int[n];
        for (int i = 0; i < n; i++) {
            rn[i] = nums[n - i - 1];
        }
        long[] tmp = new long[n + 1];
        // Arrays.fill(tmp, );
        long[][] res = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(res[0]));
            System.out.println(Arrays.toString(res[1]));
            for (int j = 1; j <= n; j++) {

                if (rn[i - 1] == nums[j - 1])
                    res[1][j] = Math.max(res[0][j - 1] + rn[i - 1], res[1][j - 1]);
                else
                    res[1][j] = Math.max(res[1][j - 1], res[0][j]);
            }
            res[0] = res[1];
            res[1] = tmp;
        }

        System.out.println(2 * sum - res[0][n]);

        scan.close();
    }

}
