package lc1_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20 {


    public boolean isValid(String s) {
        // 用栈来存储s当前字符，如果栈中弹出第一个元素与s当前字符可以匹配，弹出栈元素，下一步，如果不能，把该元素放到栈里。遍历结束，看栈中是否有元素。
        Map<Character, Character> matchMap = new HashMap<>();
        matchMap.put('(', ')');
        matchMap.put('[', ']');
        matchMap.put('{', '}');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char lastC = stack.peek();
                Character matchC = matchMap.get(lastC);
                if (matchC != null && matchC == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}[]()";

        String s2 = "{()}[]";

        String s3 = "{]";

        L20 demo = new L20();
        System.out.println(demo.isValid(s));

        System.out.println(demo.isValid(s2));
        System.out.println(demo.isValid(s3));
    }
}
