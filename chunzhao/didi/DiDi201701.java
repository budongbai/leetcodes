package didi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月22日下午6:56:31
 */
public class DiDi201701 {
    public static String reverseString(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length / 2; i++) {
            char c = ss[i];
            ss[i] = ss[ss.length - 1 - i];
            ss[ss.length - 1 - i] = c;
        }
        return new String(ss);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();
        String[] strings = string.split("\\s+");
        StringBuilder sb = new StringBuilder();
		for (String s : strings) {
			sb.append(reverseString(s)).append(" ");
		}
        System.out.println(sb.toString().trim());
        scan.close();
    }
}
