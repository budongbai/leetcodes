package datastructures.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s ="leetcode", dict =["leet", "code"]. Return true
 * because"leetcode"can be segmented as"leet code".
 *
 * @author budongbai
 * @version 2017年5月14日下午3:57:54
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] tag = new boolean[s.length() + 1];
        tag[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (tag[j] && dict.contains(s.substring(j, i))) {
                    tag[i] = true;
                    break;
                }
                System.out.println(Arrays.toString(tag));
            }
        }
        System.out.println(Arrays.toString(tag));
        return tag[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");

        WordBreak test = new WordBreak();
        System.out.println(test.wordBreak(s, dict));

        String s1 = "aaaaaaa";
        Set<String> dict1 = new HashSet<String>();
        dict1.add("aaaa");
        dict1.add("aaa");
        System.out.println(test.wordBreak(s1, dict1));

    }
}
