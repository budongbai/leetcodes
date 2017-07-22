package lianjia;
/**
 * @author budongbai
 * @version 2017年8月19日下午7:52:52
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main33 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                len++;
                nums[len - 1] = nums[i];
            }
        }
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                System.out.println(nums[i]);
            } else {
                System.out.print(nums[i] + " ");
            }
        }
        scan.close();
    }
}
