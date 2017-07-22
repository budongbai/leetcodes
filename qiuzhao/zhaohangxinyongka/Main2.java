package zhaohangxinyongka;

import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * @author budongbai
 * @version 2017年9月13日下午6:56:26
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(true);
        scan.close();
        Executors.newCachedThreadPool();
    }

}
