package ink;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月29日下午7:04:39
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        String[] nums1 = s1.split(",");
        String[] nums2 = s2.split(",");
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res ^= Integer.parseInt(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            res ^= Integer.parseInt(nums2[i]);
        }
        System.out.println(res);
        scan.close();
    }

}
