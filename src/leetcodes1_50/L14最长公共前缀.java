package leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年6月29日下午2:15:15
 */
public class L14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = "";
        // Arrays.sort(strs);
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        for (int i = 0; i < min; i++) {
            boolean flag = true;
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += c;
            } else {
                break;
            }
        }
        return res;
    }

    //比遍历还慢呢
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    //只比较首尾两个字符串,跟第一种方法速度差不多
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String res = "";
        for (int i = 0; i < strs[0].length() && i < strs[strs.length - 1].length(); i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                res += strs[0].charAt(i);
            } else {
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"adobe", "adidas", "advert", "ads"};
        System.out.println(new L14最长公共前缀().longestCommonPrefix(strs));
    }
}
