package leetcodes51_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * @author budongbai
 * @version 2017年7月21日下午8:55:22
 */
public class L76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int left = 0, right = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.getOrDefault(c, 0) > 0) {//需要字符c
                count--;
            }
            need.put(c, need.getOrDefault(c, 0) - 1);//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (left < right && need.getOrDefault(s.charAt(left), 0) < 0) {
                    //释放右边移动出窗口的字符
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    left++;//指针右移
                }
                if (right - left + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = right - left + 1;
                    start = left;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                left++;
                count++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}
