package meililianhe;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月23日下午2:50:17
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int year = scan.nextInt();
            int month = scan.nextInt();
            int day = scan.nextInt();
            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            boolean isLeap = false;
            if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                isLeap = true;
            }
            int count = 0;
            for (int i = 0; i < month - 1; i++) {
                if (i == 1 && isLeap) {
                    count += 29;
                } else {
                    count += months[i];
                }
            }

            System.out.println(count + day);

        }
        scan.close();
    }

}
