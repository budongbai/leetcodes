package xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月18日下午8:58:33
 */
public class Main11 {
    public static void main(String[] args) {
        System.out.println("_");
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str = null;

        while (!("".equals(str = sc.nextLine()))) {
            str.replaceAll(".", "_");
            char[] c = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                c[i] = str.charAt(i);
            }
            StringBuilder s = new StringBuilder("_");
            for (int i = 0; i < c.length; i++) {
                if ('0' < c[i] && c[i] < '9' && c[i - 1] < 'z' && c[i - 1] > 'A' && c[i - 1] != '_') {
                    s.append("_" + c[i]);
                }
                s.append(("" + c[i]).toUpperCase());
            }
            s.append("_");
            list.add(s.toString());
        }
        for (
            int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
