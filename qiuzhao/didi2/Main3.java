package didi2;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月10日下午2:43:09
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(res);
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            res ^= num;
            if (set.contains(res)) {
                count++;
                set.clear();
            }
            set.add(res);
            System.out.println(set);
        }
        System.out.println(count);
        scan.close();
    }

}
