package newcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月6日下午8:00:17
 */
public class JD2017 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int m = scan.nextInt();
            HashSet<Integer> s1 = new HashSet<Integer>();
            int n = scan.nextInt();
            HashSet<Integer> s2 = new HashSet<Integer>();
            for (int i = 0; i < m; i++) {
                s1.add(scan.nextInt());
            }
            for (int i = 0; i < n; i++) {
                s2.add(scan.nextInt());
            }

            s1.addAll(s2);
            Iterator<Integer> iter = s1.iterator();
            int[] array = new int[s1.size()];
            int k = 0;
            while (iter.hasNext()) {
                int i = (int) iter.next();
                array[k++] = i;
            }
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    System.out.println(array[i]);
                } else {
                    System.out.print(array[i] + " ");
                }

            }

        }
        scan.close();
    }

}
