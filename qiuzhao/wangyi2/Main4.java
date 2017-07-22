package wangyi2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月9日下午1:43:09
 */
public class Main4 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        //List<String> list = generateParenthesis(str1.length() / 2, str1);
        int max = 0;
        int count = 0;
        int res;
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        for (int i = 1; i <= str1.length() / 2; ++i) {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            res = longestCommonSubsequence(str1, lists.get(lists.size() - 1).get(i));
            if (max < res) {
                max = res;
                count = 1;
            } else if (max == res) {
                count++;
            }
        }
        System.out.println(count);
        scan.close();
    }

    // 假如返回两个字符串的最长公共子序列的长度
    public static int longestCommonSubsequence(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }
        int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
        // 初始化边界条件
        for (int i = 0; i <= str1.length(); i++) {
            matrix[i][0] = 0;
        }
        for (int j = 0; j <= str2.length(); j++) {
            matrix[0][j] = 0;
        }
        // 填充矩阵
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = (matrix[i - 1][j] >= matrix[i][j - 1] ? matrix[i - 1][j] : matrix[i][j - 1]);
                }
            }
        }
        return matrix[str1.length()][str2.length()];
    }

}
