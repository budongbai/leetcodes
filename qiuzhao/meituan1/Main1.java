package meituan1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        int n = scan.nextInt();
        int type = 0;
        while (type < 7 && n >= coins[type]) {
            n -= coins[type];
            type++;
        }
        System.out.println(type + " " + (type + n));

        scan.close();
    }
}
