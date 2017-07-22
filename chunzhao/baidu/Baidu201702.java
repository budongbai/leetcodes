package baidu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月27日下午6:43:56
 */
public class Baidu201702 {

    public static double square(int[] p1, int[] p2, int[] p3) {
        double[] sum = new double[3];
        for (int i = 0; i < p1.length; i++) {
            sum[0] += (p1[i] - p2[i]) * (p1[i] - p2[i]);
            sum[1] += (p1[i] - p3[i]) * (p1[i] - p3[i]);
            sum[2] += (p2[i] - p3[i]) * (p2[i] - p3[i]);
            if (i == 2) {
                sum[0] = Math.sqrt(sum[0]);
                sum[1] = Math.sqrt(sum[1]);
                sum[2] = Math.sqrt(sum[2]);
            }
        }
        double p = (sum[0] + sum[1] + sum[2]) * 0.5;
        if (sum[0] + sum[1] > sum[2] || sum[1] + sum[2] > sum[0] || sum[0] + sum[2] > sum[1])
            return Math.sqrt(p * (p - sum[0]) * (p - sum[1]) * (p - sum[2]));
        return -1;
    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        ArrayList<int[]> r = new ArrayList<int[]>();
        ArrayList<int[]> g = new ArrayList<int[]>();
        ArrayList<int[]> b = new ArrayList<int[]>();

        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String[] ss = s.trim().split("\\s+");
            String c = ss[0];
            int x = Integer.parseInt(ss[1]);
            int y = Integer.parseInt(ss[2]);
            int z = Integer.parseInt(ss[3]);
            if (c.equals("R")) {
                r.add(new int[]{x, y, z});
            } else if (c.equals("G")) {
                g.add(new int[]{x, y, z});
            } else if (c.equals("B")) {
                b.add(new int[]{x, y, z});
            }
        }
        double max = 0;
        if (r.size() > 2) {
            for (int i = 0; i < r.size() - 2; i++) {
                double result = square(r.get(i), r.get(i + 1), r.get(i + 2));
                //System.out.println(result);
                max = Math.max(max, result);

            }
        }
        if (g.size() > 2) {
            for (int i = 0; i < g.size() - 2; i++) {
                double result = square(g.get(i), g.get(i + 1), g.get(i + 2));
                //System.out.println(result);
                max = Math.max(max, result);

            }
        }
        if (b.size() > 2) {
            for (int i = 0; i < b.size() - 2; i++) {
                double result = square(b.get(i), b.get(i + 1), b.get(i + 2));
                //System.out.println(result);
                max = Math.max(max, result);
            }
        }
        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < g.size(); j++) {
                for (int k = 0; k < b.size(); k++) {
                    double result = square(r.get(i), g.get(j), b.get(k));
                    max = Math.max(max, result);
                }
            }
        }
        DecimalFormat df2 = new DecimalFormat("#.00000");

        System.out.println(df2.format(max));
        scan.close();
        //System.out.println((double) (Math.round(max*10000)/10000.0));
    }

}
