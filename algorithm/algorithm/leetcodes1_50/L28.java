package algorithm.leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年7月5日上午11:47:11
 */
public class L28 {
    /**
     * needle在haystack中第一次出现的位置
     *
     * @param haystack
     * @param needle
     * @return
     * @author budongbai
     * @version 2017年7月5日上午11:49:27
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals(haystack)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() <= haystack.length() && needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }
        return -1;
    }


    public int strStr3(String haystack, String needle) {
        // KMP算法
        int n = haystack.length(), m = needle.length();

        if (m == 0) {
            return 0;
        }

        int[] pi = new int[m];

        // 计算next数组，用于下一步遍历过程中跳过相同前缀的内容
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public static void main(String[] args) {
        L28 demo = new L28();
        demo.strStr3("abcaabcd", "abcd");
    }
}
