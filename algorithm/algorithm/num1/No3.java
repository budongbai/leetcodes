

package algorithm.num1;

import java.util.HashMap;
import java.util.Map;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 把i跳到 第j个字符上一次出现的位置
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abcdbea";
        No3 no3 = new No3();
        System.out.println(no3.lengthOfLongestSubstring(s));
    }
}
