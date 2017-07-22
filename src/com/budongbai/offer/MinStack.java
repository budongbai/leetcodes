package com.budongbai.offer;

import java.util.Stack;

public class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.empty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
