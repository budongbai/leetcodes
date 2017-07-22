package sohu;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月17日下午6:54:47
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        long sum = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (nums[left] == nums[right]) {
                sum += nums[left] * 2;
                left++;
                right--;

            } else if (nums[left] < nums[right]) {
                sum += nums[left] * 2;
                left++;

            } else if (nums[left] > nums[right]) {
                sum += nums[right] * 2;
                right--;
            }
            // System.out.println("left = "+ left + ", right = "+ right + ", sum
            // = " + sum);
        }
        if (left == right) {
            sum += nums[left];
        }
        System.out.println(sum);
        // 8 51 23 52 97 97 76 23 51
        // 5 1 2 3 1 2
        scan.close();
    }

}
