package algorithm.leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月15日下午4:24:43
 */
public class L65 {
    public int[] plusOne(int[] digits) {

        int jinwei = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1)
                sum = digits[i] + 1;
            else {
                sum = digits[i] + jinwei;
            }
            jinwei = sum / 10;
            digits[i] = sum % 10;
        }
        if (jinwei != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = jinwei;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

    //It is so smart
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            //当某位数小于9的时候，恰好++，也把进位考虑进去了。
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //==9,则当前为0，进位1
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        //这里没有拷贝其他的值是因为只有所有位上的数都是9的时候才会需要申请一个新的空间
        return newNumber;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res = new L65().plusOne(nums);
        System.out.println(Arrays.toString(res));
    }

}
