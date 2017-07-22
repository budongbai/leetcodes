package newcoder;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月7日下午6:23:47
 */
public class JD2017S1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n;
        String ps;
        while (scan.hasNext()) {
            n = scan.nextInt();
            ps = scan.next();

            char[] p = ps.toCharArray();
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                //如果是警察
                //System.out.println("i="+ i+ " "+ p[i]);
                if (p[i] > '0' && p[i] <= '9') {
                    int range = Integer.parseInt(p[i] + "");
                    for (int j = 1; j <= range; j++) {
                        //	System.out.println(i-j + " "+ (i+j));
                        if (i - j >= 0 && p[i - j] == 'X') {
                            set.add(i - j);
                        }
                        if (i + j < n && p[i + j] == 'X') {
                            set.add(i + j);
                        }
                    }
                }
            }
            System.out.println(set.size());

        }
        scan.close();
    }

}
