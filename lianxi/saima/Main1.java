package saima;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            int n = scan.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scan.nextInt();
            }
            if (n == 1) {
                System.out.println("No");
            } else {
                Arrays.sort(nums);
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += nums[i];
                }
                if (nums[n - 1] <= sum - nums[n - 1]) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }

        }
        scan.close();
    }

}
