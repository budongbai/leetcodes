package toutiao1;

import java.util.Scanner;

/**
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和
 * 最后程序输出经过计算后的最大值即可，不需要输出具体的区间
 *
 * @author budongbai
 * @version 2017年8月22日下午6:36:29
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        long res = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = nums[i];
                int min = nums[i];
                for (int k = i + 1; k <= j; k++) {
                    sum += nums[k];
                    min = Math.min(min, nums[k]);
                }
                long tmp = sum * min;
                res = Math.max(res, tmp);
            }
        }
        System.out.println(res);

        scan.close();
    }
}
