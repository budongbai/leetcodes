package sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author budongbai
 * @version 2017年9月8日下午3:59:18
 */
public class Main2 {

    public static void main(String[] args) {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String ns = buf.readLine();
            int n = Integer.parseInt(ns);
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Double.parseDouble(buf.readLine());
            }
            double max = 0.0;

            for (int i = 0; i < n - 1; i++) {

                if (arr[i] < 180.0) {
                    double m = arr[i];
                    m += 180;
                    int j = search(arr, m);
                    // System.out.println(j);
                    double ij = Math.abs(arr[i] - arr[j]);
                    ij = ij > 180 ? 360 - ij : ij;
                    double ij3 = Math.abs(arr[i] - arr[j + 1]);
                    ij3 = ij3 > 180 ? 360 - ij3 : ij3;
                    double t = Math.max(ij3, ij);
                    max = Math.max(max, t);
                }

            }

            java.text.DecimalFormat df = new java.text.DecimalFormat("#.00000000");
            System.out.println(df.format(max));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static int search(double[] nums, double num) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (num >= nums[middle] && middle + 1 < nums.length && num < nums[middle + 1]) {
                return middle;
            } else if (num < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
