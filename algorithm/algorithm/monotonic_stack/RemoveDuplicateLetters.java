package algorithm.monotonic_stack;

import java.util.Stack;

public class RemoveDuplicateLetters {

    /**
     * <a href="https://leetcode.cn/problems/remove-duplicate-letters/">316. 去除重复字母</a>
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
     * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *
     */
    String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量
        // 因为提示说明s由小写英文字母组成，26够用了
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 标记字母是否在栈中，如果在栈中
        boolean[] inStack = new boolean[26];
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，都将对应的计数减一
            count[c - 'a']--;

            if (inStack[c - 'a']) continue;

            // 比较当前字母与栈顶字母大小，栈顶大，则将栈顶字母弹出
            while (!stk.isEmpty() && stk.peek() > c) {
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek() - 'a'] == 0) {
                    break;
                }
                // 若之后还有，则可以 pop
                inStack[stk.pop() - 'a'] = false;
            }
            stk.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }

}
