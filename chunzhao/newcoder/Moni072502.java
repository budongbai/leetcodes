package newcoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年7月25日下午7:41:22
 */
public class Moni072502 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int numJi = 0;
        for (int i : map.values()) {
            if (i % 2 == 1) {
                numJi++;
            }
        }
        System.out.println(numJi == 0 ? 1 : numJi);
        scan.close();
    }

}
