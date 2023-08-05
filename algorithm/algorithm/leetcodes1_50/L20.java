package algorithm.leetcodes1_50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author budongbai
 * @version 2017年7月2日下午8:58:22
 */
public class L20 {
    //栈不为空，与栈顶元素匹配，未匹配成功，压入栈，否则弹出栈顶元素。直到所有符号遍历完，如果栈不为空，则false
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        char c = s.charAt(0);
        stack.push(c);
        int i = 1;
        while (i < s.length()) {
            c = s.charAt(i);
            char temp;
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                switch (c) {
                    case ']':
                        temp = stack.peek();
                        if (temp == '[')
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    case '}':
                        temp = stack.peek();
                        if (temp == '{')
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    case ')':
                        temp = stack.peek();
                        if (temp == '(')
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    default:
                        stack.push(c);
                }
            }

            i++;
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
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
        L20 test = new L20();
        System.out.println(test.isValid("[()]"));
        System.out.println(test.isValid("[({)}]"));
    }

}
