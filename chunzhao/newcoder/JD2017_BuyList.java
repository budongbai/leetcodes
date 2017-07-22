package newcoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月6日下午8:28:49
 */
public class JD2017_BuyList {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] price = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = scan.nextInt();
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < m; i++) {
                String str = scan.next();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1);
                }
            }
            System.out.println();
            Arrays.sort(price);
            int min = 0;
            int max = 0;
            int[] things = new int[map.size()];
            Collection<Integer> c = map.values();
            Iterator<Integer> iter = c.iterator();
            int k = 0;
            while (iter.hasNext()) {
                int num = (int) iter.next();
                things[k++] = num;
            }
            Arrays.sort(things);
            for (int i = 0; i < things.length; i++) {
                min += price[i] * things[things.length - 1 - i];
                max += price[price.length - 1 - i] * things[things.length - 1 - i];
            }
            System.out.println(min + " " + max);
        }
        scan.close();
    }

}
