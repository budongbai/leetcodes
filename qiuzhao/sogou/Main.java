package sogou;
/**
 * @author budongbai
 * @version 2017年9月8日下午5:54:52
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            int n = Integer.parseInt(input);
            double[] na = new double[n];
            for (int i = 0; i < n; i++) {
                na[i] = Double.parseDouble(reader.readLine());
            }
            double max = 0;
            for (int i = 0; i < n; i++) {
                for (int k = i + 1; k < n; k++) {
                    double temp = na[k] - na[i];
                    if (temp > 180.0) {
                        temp = 360.0 - temp;
                    }
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
            System.out.println(String.format("%.8f", max));
        } catch (IOException e) {
        }
    }

}
