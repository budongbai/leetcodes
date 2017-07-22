package pinduoduo2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月2日下午3:38:15
 */
class Bear<T> implements Comparable<T> {
    int zhandouli;
    int jiezhi;

    public Bear(int zhandouli, int jiezhi) {
        this.zhandouli = zhandouli;
        this.jiezhi = jiezhi;
    }

    @Override
    public int compareTo(T o) {

        Bear<?> b = (Bear<?>) o;
        return this.zhandouli - b.zhandouli;
    }

}

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] candies = new int[m];
        for (int i = 0; i < m; i++) {
            candies[i] = scan.nextInt();
        }
        Arrays.sort(candies);

        Bear[] bears = new Bear[n];
        for (int i = 0; i < n; i++) {
            int zhandouli = scan.nextInt();
            int jiezhi = scan.nextInt();
            bears[i] = new Bear(zhandouli, jiezhi);
        }
        Arrays.sort(bears);
        boolean[] flag = new boolean[m];
        Arrays.fill(flag, true);
        for (int i = n - 1; i >= 0; i--) {
            Bear b = bears[i];
            int j = m - 1;
            while (b.jiezhi > 0 && j >= 0) {
                if (flag[j] && candies[j] <= b.jiezhi) {
                    flag[j] = false;
                    b.jiezhi -= candies[j];
                }
                j--;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(bears[i].jiezhi);
        }
        scan.close();
    }
}
