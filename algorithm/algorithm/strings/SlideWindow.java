package algorithm.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 * <p>
 * 滑动窗口的思想：
 * 用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，
 * 当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
 * <p>
 * 步骤一
 * 不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
 * <p>
 * 步骤二
 * 不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，直到碰到一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，记录此时滑动窗口的长度，并保存最小值
 * <p>
 * 步骤三
 * 让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，如此反复，直到j超出了字符串S范围。
 * <p>
 * 作者：Mcdull0921
 * 链接：https://leetcode.cn/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SlideWindow {
    /**
     * <a href="https://leetcode.cn/problems/minimum-window-substring/">76. 最小覆盖子串</a>
     * <p></p>
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 左指针，右指针，所需字符总个数，最小窗口的起始index，窗口大小
        int left = 0, right = 0, count = t.length(), start = 0, size = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);

            if (need.getOrDefault(c, 0) > 0) {
                count--;
            }
            // 更新所需要字符数量
            need.put(c, need.getOrDefault(c, 0) - 1);

            if (count == 0) {
                // 满足了条件，开始移动左指针
                while (left < right && need.getOrDefault(s.charAt(left), 0) < 0) {
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                    left++;
                }
                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1);
                left++;
                count++;
            }

            // 移动右指针
            right++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    /**
     * <a href="https://leetcode.cn/problems/permutation-in-string/">567. 字符串的排列</a>
     * <p>
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String t, String s) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    /**
     * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
     * <p></p>
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int right, left = 0, max = 0;
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

    public static void main(String[] args) {
        SlideWindow slideWindow = new SlideWindow();
        System.out.println();
        slideWindow.checkInclusion2("abca", "acabd");
    }

}
