package algorithm.leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月16日上午9:38:45
 */
public class L8字符串转整型数 {

    public int myAtoi(String str) {
        str = str.trim();
        int len = str.length();

        long res = 0;
        boolean negative = false;
        int start = 0;
        if (str.startsWith("-")) {
            negative = true;
            start = 1;
        } else if (str.startsWith("+")) {
            start = 1;
        }

        if (len > 13) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        for (int i = start; i < len; i++) {
            char c = str.charAt(i);
            int tmp = getNum(c);
            if (tmp == -1) {
                return 0;
            } else if (tmp == -2) {
                res = negative ? -res : res;
                if (res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                return (int) res;
            }
            long newRes = res * 10 + tmp;
            if ((newRes - tmp) / 10 != res) {
                return 0;
            }
            res = newRes;
            System.out.println(res);
        }
        res = negative ? -res : res;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) res;
    }

    public static int getNum(char c) {
        int res = 0;
        switch (c) {
            case '1':
                res = 1;
                break;
            case '2':
                res = 2;
                break;
            case '3':
                res = 3;
                break;
            case '4':
                res = 4;
                break;
            case '5':
                res = 5;
                break;
            case '6':
                res = 6;
                break;
            case '7':
                res = 7;
                break;

            case '8':
                res = 8;
                break;
            case '9':
                res = 9;
                break;
            case '0':
                res = 0;
                break;

            case '+':
                res = -1;
                break;
            case '-':
                res = -1;
                break;
            default:
                res = -2;
                break;
        }
        return res;
    }

    public int myAtoi2(String str) {
        //空
        if (str == null) {
            return 0;
        }
        //处理空字符
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //符号
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        char c = str.charAt(0);
        if (c == '+') {
            start += 1;
        } else if (c == '-') {
            sign = -1;
            start += 1;
        }

        //转换
        for (int i = start; i < len; i++) {
            c = str.charAt(i);
            //碰到非数字字符，则返回结果
            if (!Character.isDigit(c)) {
                return (int) sum * sign;
            }
            sum = sum * 10 + (c - '0');//用ascii码直接减就可以，不用switch一一区别
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && -1 * sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }


        }
        return (int) sum * sign;
    }

}
