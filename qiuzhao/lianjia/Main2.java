package lianjia;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月19日下午6:30:46
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = scan.nextInt();
        for (int i = 1; i < n; i++) {
            nums[i + 1] = scan.nextInt() + nums[i];
        }

        int q = scan.nextInt();
        int[] qs = new int[q];
        for (int i = 0; i < q; i++) {
            qs[i] = scan.nextInt();

        }
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < n; j++) {
                if (qs[i] > nums[j] && qs[i] <= nums[j + 1]) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
        scan.close();
    }
}
