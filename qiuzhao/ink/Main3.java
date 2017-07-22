package ink;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月29日下午7:14:11
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = count++;
            }
            rowBegin++;


            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = count++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {

                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = count++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {

                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = count++;
                }
            }
            colBegin++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }

}
