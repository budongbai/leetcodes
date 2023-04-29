package algorithm.offer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 */
public class Print1ToMaxOfNDigits {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int length = (int) Math.pow(10, n);

        int[] array = new int[length - 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        return array;
    }


    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        Arrays.fill(number, '0');

        while (!increment(number)) {
            print(number);
        }
    }

    private boolean increment(char[] number) {
        boolean isOverflow = false;

        int nTakeOver = 0; // 是否有进位

        int length = number.length;

        for (int i = length - 1; i >= 0; i--) {
            // 第n位的值
            int nSum = number[i] - '0' + nTakeOver;

            // 从个位开始++，一直进位计算到最高位
            if (i == length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                // 最高位，还有进位，说明到结束的时候了
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }

            } else {
                // 不需要向高一位进位的话，直接加就完事
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    private void print(char[] number) {
        boolean flag = true;
        for (char digit : number) {
            if (flag && digit == '0') {
                continue;
            }
            flag = false;
            System.out.print(digit);
        }
        System.out.println();
    }

    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number, '0');

        for (int i = 0; i < 10; i++) {
            number[0] = (char) ('0' + i);
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }

    }

    private void print1ToMaxOfNDigitsRecursively(char[] number, int n, int index) {
        if (index == n - 1) {
            print(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) ('0' + i);
            print1ToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits demo = new Print1ToMaxOfNDigits();
        demo.print1ToMaxOfNDigits2(5);
        BigInteger bigInteger = new BigInteger("234455");
    }
}
