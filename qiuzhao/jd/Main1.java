package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author budongbai
 * @version 2017年9月8日下午6:48:40
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        int i = 1;
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
                list.add(count);
                count = 0;
            } else {
                stack.push(c);
                count++;
            }
            i++;
        }
        long sum = 1;
        for (i = 0; i < list.size(); i++) {
            sum *= product(list.get(i));
        }
        System.out.println(sum);
        scan.close();
    }

    public static long product(int num) {
        if (num > 1) {
            return product(num - 1) * num;
        } else {
            return 1;
        }
    }

}
