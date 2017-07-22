package didi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月26日下午2:23:49
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] ss = s.split("\\s+");
        int[] nums = new int[ss.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);
        scan.close();
    }

}
