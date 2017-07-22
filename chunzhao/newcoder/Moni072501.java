package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年7月25日下午7:22:56
 */
public class Moni072501 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int len = s.length();
        for (int i = len - 2; i >= 0; i -= 2) {
            //System.out.println(s.substring(0, i/2)+ "," + s.substring(i/2, i));
            if (s.substring(0, i / 2).equals(s.substring(i / 2, i))) {
                System.out.println(i);
                break;
            }
        }
        scan.close();

    }

}
