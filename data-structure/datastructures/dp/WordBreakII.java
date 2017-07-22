package datastructures.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word. Return all such
 * possible sentences. For example, given s ="catsanddog", dict =["cat", "cats",
 * "and", "sand", "dog"]. A solution is["cats and dog", "cat sand dog"].
 *
 * @author budongbai
 * @version 2017年5月20日下午3:30:23
 */
public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        helper(s, dict, 0, "", res);
        return res;
    }

    private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res) {
        if (start >= s.length()) {
            res.add(item);

            return;
        }
        StringBuilder str = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            str.append(s.charAt(i));

            if (dict.contains(str.toString()))// 如果包含这个子串，则从i+1再次递归，看i+1之后的子串是否也被包含在dict里面。
            {
                String newItem = item.length() > 0 ? (item + " " + str.toString()) : str.toString();

                helper(s, dict, i + 1, newItem, res);

            }
        }
    }

    public ArrayList<String> wordBreak2(String s, Set<String> dict) {
        ArrayList<String> list = new ArrayList<String>();
        boolean[] flag = new boolean[s.length()];// flag[i]==true,表示从i位置往后分割不出满足条件的串。
        func(list, s, "", 0, s.length(), dict, flag);
        return list;
    }

    private void func(ArrayList<String> list, String s, String ans, int i, int n, Set<String> dict, boolean[] flag) {
        for (int j = i + 1; j <= n; j++) {
            String tmp = ans;
            if (dict.contains(s.substring(i, j))) {
                if (j == n) {
                    tmp += s.substring(i, j);
                    list.add(tmp);
                } else {
                    if (flag[j] == false) {
                        int oldsize = list.size();
                        tmp += (s.substring(i, j) + " ");
                        System.out.println(list.toString());
                        func(list, s, tmp, j, n, dict, flag);
                        if (oldsize == list.size())
                            flag[j] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        String s = "catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        WordBreakII test = new WordBreakII();
        System.out.println(test.wordBreak2(s, dict));
        String s1 = "aaaaaaa";
        Set<String> dict1 = new HashSet<String>();
        dict1.add("aaaa");
        dict1.add("aa");
        System.out.println(test.wordBreak(s1, dict1));
    }

}
