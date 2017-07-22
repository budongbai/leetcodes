package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月6日下午7:32:29
 */
public class Main2 {

    public static void cal(int[] arr, int m) {
        int num = 0;
        int index = -1;
        int count = 0;
        int i = 0;
        int[] res = new int[m - 1];
        while (num < 100) {
            index++;
            if (index >= arr.length)
                index = 0;
            if (arr[index] == 1)
                count++;
            if (count == m) {
                arr[index] = 0;
                num++;
                res[i++] = index + 1;
                if (i == m - 1) {
                    i = 0;
                }
                count = 0;
            }
        }
        Arrays.sort(res);
        for (i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.println(res[i]);
            } else {
                System.out.print(res[i] + ",");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        if (m >= 100 || m <= 1) {
            System.out.println("ERROR!");
        } else {
            int[] nums = new int[100];

            for (int i = 0; i < 100; i++) {
                nums[i] = 1;
            }
            cal(nums, m);
        }
        scan.close();
    }
}
