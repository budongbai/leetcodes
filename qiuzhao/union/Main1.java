package union;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月20日下午2:29:00
 */
public class Main1 {

    public static void hanoi(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println(a + "-" + n + "-" + c);
        else {
            hanoi(n - 1, a, c, b);
            System.out.println(a + "-" + n + "-" + c);
            hanoi(n - 1, b, a, c);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        hanoi(x, 'A', 'B', 'C');

    }

}
