package souhu17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月28日下午7:58:18
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] table = new int[n + 10];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scan.nextInt();
        }

        int k = 0;
        int dig;
        if (b[0] == 1) {
            table[0] = b[0];
            table[1] = b[1];
        } else {
            table[0] = b[0];
            table[1] = b[0];
        }
        for (int i = 0, top = 0; top <= n; ++i) {
            dig = b[k];
            k = k + 1;
            if (k == m)
                k = 0;
            for (int j = 0; j < table[i] && top <= n; ++j) {
                table[top++] = dig;
            }
        }
        System.out.println(Arrays.toString(table));
        scan.close();
    }

}
