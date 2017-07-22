package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月27日下午6:43:56
 */
public class Baidu201701 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        Arrays.sort(nums);
        int now = nums[0];
        int count = 1, i = 1;
        while (i < n && count < 3) {
            if (now == nums[i]) {
                i++;
            } else {
                now = nums[i];
                count++;
            }
        }
        if (count == 3)
            System.out.println(now);
        else {
            System.out.println("-1");
        }
        scan.close();
    }

}
