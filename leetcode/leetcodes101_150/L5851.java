package leetcodes101_150;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class L5851 {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, nums);
        char[] arr = new char[nums[0].length()];
        Arrays.fill(arr, '0');
        for (int i = 0, n = nums[0].length(); i < n + 1; i++) {
            String str = new String(arr);
            if (!set.contains(str)) {
                return str;
            }
            for (int j = 0; j < n; j++) {
                if (arr[j] == '0') {
                    arr[i] = '1';
                    break;
                }
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String[] strings = {"00000","11111", "01111", "10011"};
        String s = new L5851().findDifferentBinaryString(strings);

        System.out.println(s);
    }
}
