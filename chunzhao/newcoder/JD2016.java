package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月2日下午10:17:27
 */
public class JD2016 {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            char[][] array = new char[3][3];
            int zCount = 0, xCount = 0;
            for (int i = 0; i < 3; i++) {
                String str = scan.next();
                for (int j = 0; j < 3; j++) {
                    array[i][j] = str.charAt(j);
                    if (str.charAt(j) == 'X') {
                        xCount++;
                    } else if (str.charAt(j) == '0') {
                        zCount++;
                    }
                }
            }

            int diff = xCount - zCount;
            if (diff != 1 && diff != 0) {
                System.out.println("x");
                continue;
            }
            boolean win1 = false, win2 = false;
            for (int i = 0; i < 3; i++) {
                if (array[i][1] != '.' && array[i][0] == array[i][1] && array[i][1] == array[i][2]) {
                    if (array[i][1] == 'X') {
                        win1 = true;
                    } else {
                        win2 = true;
                    }
                }
                if (array[1][i] != '.' && array[0][i] == array[1][i] && array[1][i] == array[2][i]) {
                    if (array[1][i] == 'X') {
                        win1 = true;
                    } else {
                        win2 = true;
                    }
                }
            }
            if (array[1][1] != '.' && (array[0][0] == array[1][1] && array[1][1] == array[2][2])
                || (array[0][2] == array[1][1] && array[1][1] == array[2][0])) {
                if (array[1][1] == 'X') {
                    win1 = true;
                } else {
                    win2 = true;
                }
            }
            if (win1 && win2 || win1 && diff == 0 || win2 && diff == 1) {
                System.out.println("x");
            } else if (win1) {
                System.out.println("1 won");
            } else if (win2) {
                System.out.println("2 won");
            } else if (xCount + zCount == 9) {
                System.out.println("draw");
            } else if (diff == 0) {
                System.out.println("1");
            } else if (diff == 1) {
                System.out.println("2");
            }
        }
        scan.close();
    }
}
