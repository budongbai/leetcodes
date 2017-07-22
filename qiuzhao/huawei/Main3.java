package huawei;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月6日下午7:54:26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] data = new int[n];
        int[] jiu = new int[m];

        for (int i = 0; i < data.length; i++) {
            data[i] = scan.nextInt();
            if (i < m) {
                jiu[i] = data[i];
            }
        }
        int count = 0;
        //如果有酒
        while (hasJiu(jiu)) {
            int min = min(jiu);
            count += min;
            for (int i = 0; i < jiu.length; i++) {
                jiu[i] -= min;
                if (m < data.length && jiu[i] == 0) {
                    jiu[i] = data[m++];
                }
            }
        }
        System.out.println(count);
        scan.close();
    }

    private static int min(int[] jiu) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < jiu.length; i++) {
            if (jiu[i] > 0 && min > jiu[i]) {
                min = jiu[i];
            }
        }
        return min;
    }

    private static boolean hasJiu(int[] jiu) {
        for (int i = 0; i < jiu.length; i++) {
            if (jiu[i] > 0) {
                return true;
            }
        }
        return false;
    }
}
