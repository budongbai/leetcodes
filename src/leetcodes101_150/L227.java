package leetcodes101_150;

import java.util.Stack;

public class L227 {
    public int calculate(String s) {

        // 双栈一个记录数字，一个记录符号，每次碰到符号时，看符号栈栈顶是否为*或者/，是的话，计算并压栈，最终剩下+-没计算，倒到另一个栈里，遍历计算
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                number.append(ch);
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // 遇到符号，将数字入栈
                numberStack.push(Integer.parseInt(number.toString()));
                number.delete(0, number.length());

                if (!operatorStack.isEmpty()) {
                    char c = operatorStack.peek();
                    if (c == '*' || c == '/') {
                        operatorStack.pop();
                        int number2 = numberStack.pop();
                        int number1 = numberStack.pop();

                        int result = calculate(number1, number2, c);
                        numberStack.push(result);
                    }

                }
                operatorStack.push(ch);
            }
        }
        numberStack.push(Integer.parseInt(number.toString()));
        number.delete(0, number.length());
        Stack<Integer> numberStack2 = new Stack<>();
        Stack<Character> operatorStack2 = new Stack<>();
        while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
            char c = operatorStack.pop();

            int number2 = numberStack.pop();
            int number1 = numberStack.pop();
            int result = calculate(number1, number2, c);
            numberStack.push(result);
        }

        while (!operatorStack.isEmpty()) {
            operatorStack2.push(operatorStack.pop());
        }
        while (!numberStack.isEmpty()) {
            numberStack2.push(numberStack.pop());
        }

        while (!operatorStack2.isEmpty() && !numberStack2.isEmpty()) {
            char c = operatorStack2.pop();
            int number1 = numberStack2.pop();
            int number2 = numberStack2.pop();
            int result = calculate(number1, number2, c);
            numberStack2.push(result);
        }
        return numberStack2.peek();
    }

    private int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '/':
                return num1 / num2;
            case '*':
                return num1 * num2;
        }
        return 0;
    }

    public int calculate2(String s) {
        char preSign = '+';

        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new L227().calculate2("282-1*2*13-30-2*2*2/2-95/5*2+55+804+3024"));
    }
}
