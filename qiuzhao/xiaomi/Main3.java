package xiaomi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月18日下午8:43:58
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        while (scan.hasNext()) {
            String n = scan.next();
            for (int i = 0; i < n.length(); i++) {
                System.out.print((char) (n.charAt(i) + 'a' - '1'));
            }
            System.out.println();
            for (int i = 0; i < n.length(); i++) {

            }

        }

    }

}
