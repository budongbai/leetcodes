package algorithm.leetcodes1_50;

import java.util.HashMap;

/**
 * @author budongbai
 * @version 2017年6月14日下午4:12:17
 */
public class L3无重复字符最长子串 {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int right = 0, left = 0, max = 0;
        map.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            right = i;
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index >= left) {
                    left = index + 1;
                }
            }
            map.put(c, i);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果已经包含当前字符,找到当前字符上次出现的位置
            if (map.containsKey(s.charAt(i))) {
                // 把left跳到第i个字符上一次出现的位置的next位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 更新当前字符最后出现的位置
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
