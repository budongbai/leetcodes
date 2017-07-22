package wangyi2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月9日下午1:43:09
 */
public class Main3 {
    public static List<String> generateParenthesis(int n, String str) {
        List<String> list = new LinkedList<String>();
        String s = "";
        generate(n, n, s, (LinkedList<String>) list, str);
        return list;
    }

    private static void generate(int leftNum, int rightNum, String s, LinkedList<String> result, String str) {
        // 当左右值为0时，得到一个合法排列
        if (leftNum == 0 && rightNum == 0 && !s.equals(str)) {
            result.push(s);
        }
        // 如果左值大于0，则可以继续大于左括号
        if (leftNum > 0) {
            generate(leftNum - 1, rightNum, s + '(', result, str);
        }
        // 如果右值大于0并且左值小于右值，只能打印右括号
        if (rightNum > 0 && leftNum < rightNum) {
            generate(leftNum, rightNum - 1, s + ')', result, str);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        List<String> list = generateParenthesis(str1.length() / 2, str1);
        int max = 0;
        int count = 0;
        int res;
        for (int i = 0; i < list.size(); i++) {
            res = longestCommonSubsequence(str1, list.get(i));
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
