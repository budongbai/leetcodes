package saima;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static int func(int n, int[] number) {
        int[] count = new int[n];
        Arrays.fill(count, 1);// 初始化一个 长度为n值为1的count数组
        for (int i = 0; i < n; i++) {// 遍历，
            int x = number[i];
            for (int j = 0; j < i; j++) {
                if (number[j] != x) {
                    number[j] = x;
                    count[j] += 1;
                }
            }
        }
        Arrays.sort(count);
        return count[n - 1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {

            int n = scan.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scan.nextInt();
            }

            int max = func(n, nums);
            System.out.println(max);

        }
        scan.close();
    }

}
