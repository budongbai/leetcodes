package sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author budongbai
 * @version 2017年9月8日下午3:59:18
 */
public class Main1 {

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
                for (int j = i + 1; j < n; j++) {
                    double tmp = arr[j] - arr[i];
                    if (tmp > 180.0) {
                        tmp = 360 - tmp;
                    }
                    max = Math.max(max, tmp);

                }
            }
            System.out.println(String.format("%.8f", max));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            buf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
