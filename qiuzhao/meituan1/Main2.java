package meituan1;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        //谁先碰到以1为结尾的，谁就赢
        if (nums[n - 1] == 0) {
            System.out.println("Bob");
        } else {
            System.out.println("Alice");
        }

        scan.close();
    }
}
