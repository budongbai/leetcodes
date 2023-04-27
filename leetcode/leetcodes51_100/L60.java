package leetcodes51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月13日下午1:15:39
 */
public class L60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int[] f = new int[n];
        f[0] = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum *= i;
            f[i] = sum;
        }
        k = k - 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            int index = k / f[n - i];
            sb.append(String.valueOf(nums.get(index)));
            nums.remove(index);
            k -= index * f[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        L60 test = new L60();
        String res = test.getPermutation(4, 14);
        System.out.println(res);
    }
}
