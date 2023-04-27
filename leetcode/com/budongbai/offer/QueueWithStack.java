package com.budongbai.offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class QueueWithStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // stack2不为空时，就从stack2弹元素
        if (!stack2.empty()) {
            return stack2.pop();
        }
        // stack2为空，且stack1不为空，把stack1中的元素全部压到stack2里，再从stack2弹元素
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        if (!stack2.empty()) {
            return stack2.pop();
        }
        return -1;
    }
}
