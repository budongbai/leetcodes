package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年3月23日下午7:28:58
 */
public class PingHengShu {

    public int getLength(int number) {
        int s = number / 10;
        int length = 1;
        while (s != 0) {
            length++;
            s = s / 10;
        }

        return length;
    }

    public int[] getNumbers(int number, int length) {
        int[] numbers = new int[length];
        int d = number % 10;
        int s = number / 10;
        int i = length - 1;
        while (s > 9) {
            //System.out.println(d);
            numbers[i] = d;
            i--;
            d = s % 10;
            s = s / 10;
        }
        numbers[i] = d;
        //System.out.println(s);
        numbers[0] = s;
        return numbers;
    }

    public static void main(String[] args) {

        PingHengShu test = new PingHengShu();
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        boolean out = false;
        int length = test.getLength(number);
        if (length >= 2) {
            int[] numbers = test.getNumbers(number, length);
            int m, i, j;
            int mut1 = 1;
            int mut2 = 1;
            for (m = 0; m < numbers.length - 1; m++) {
                for (i = 0; i <= m; i++) {
                    mut1 = mut1 * numbers[i];
                }
                for (j = numbers.length - 1; j >= i; j--) {
                    mut2 = mut2 * numbers[j];
                }
                if (mut1 == mut2) {
                    out = true;
                    break;
                }
                mut1 = 1;
                mut2 = 1;
            }
            if (out) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scan.close();
    }

}
