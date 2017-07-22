package meitu;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月16日下午6:56:08
 */
public class Meitu201701 {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];

        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine().trim();
            String[] strs = str.split(",");
            int[] nums = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            System.out.println(singleNumber(nums));
        }
        scan.close();
    }
}
