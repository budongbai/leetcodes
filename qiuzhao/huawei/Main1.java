package huawei;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月6日下午6:39:43
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        StringBuilder sb = new StringBuilder();

        String maxStr = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (maxStr == null || sb.toString().length() >= maxStr.length()) {
                    maxStr = sb.toString();
                }
                sb.delete(0, sb.length());
            }
        }
        if (maxStr == null || sb.toString().length() >= maxStr.length()) {
            maxStr = sb.toString();
        }
        if (maxStr == null) {
            System.out.println("");
            System.out.println(0);
        } else {
            System.out.println(maxStr);
            System.out.println(maxStr.length());
        }

        scan.close();
    }

}
