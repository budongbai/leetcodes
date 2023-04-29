package algorithm.leetcodes101_150;

import java.util.Stack;

/**
 * 557. 反转字符串中的单词 III
 */
public class L557 {

    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(' ');
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        L557 demo = new L557();

        String s = demo.reverseWords("Let's take LeetCode contest");
        System.out.println(s);

    }
}
