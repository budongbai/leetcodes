package sf;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月20日下午4:35:55
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int len = 1000000009;
        int bit = bit(n);
        int count1 = pow(2, bit) - 2;
        int count2 = pow(2, bit + 1) - 2;
        int res = count1;
        for (int i = count1; i <= count2; i++) {
            String str = getLuckNumber(i);
            Long num = Long.parseLong(str);
            if (num > n) {

                res = i;
                break;
            }
        }
        System.out.println(res - 1);


    }

    public static String getLuckNumber(int n) {

        String str = Integer.toBinaryString(n);

        int level = str.length();
        if (!str.contains("0")) {
            level += 1;
        }

        int m = n - ((1 << (level - 1)) - 2);

        String result = Integer.toBinaryString(m - 1);
        while (result.length() < level - 1) {
            result = "0" + result;
        }

        result = result.replace("0", "4");
        result = result.replace("1", "7");
        return result;
    }

    public static int bit(long n) {
        int bit = 0;
        while (n != 0) {
            n /= 10;
            bit++;
        }
        return bit;
    }

    public static int pow(int n, int bit) {
        int res = 1;
        int count = 0;
        while (count < bit) {
            res = res * n % 1000000009;
            count++;
        }
        return res;
    }

}
