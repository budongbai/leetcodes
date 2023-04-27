package leetcodes101_150;

import java.util.Stack;

public class L151 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() != 0) {
                    stack.push(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            stack.push(sb.toString());
            sb.delete(0, sb.length());
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        if (sb.length() != 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

}
