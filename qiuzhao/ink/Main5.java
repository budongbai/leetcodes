package ink;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月29日下午7:14:11
 */
public class Main5 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];

        int maxI = matrix.length, minI = 0;

        int maxJ = matrix[0].length, minJ = 0;

        int i = 0, j = 0;
        boolean[][] visited = new boolean[maxI][maxJ];

        int count = 1;// 用来计数是否到了最后。
        while (count <= matrix.length * (matrix[0].length)) {
            while (j < maxJ) {
                if (!visited[i][j])
                    matrix[i][j] = count++;
                visited[i][j] = true;

                j++;
            }
            maxJ--;
            j--;
            i++;
            while (i < maxI) {
                if (!visited[i][j])
                    matrix[i][j] = count++;
                visited[i][j] = true;

                i++;
            }
            maxI--;
            i--;
            j--;
            while (j >= minJ) {
                if (!visited[i][j])
                    matrix[i][j] = count++;
                visited[i][j] = true;
                j--;

            }

            minI++;
            j++;
            i--;
            while (i >= minI) {
                if (!visited[i][j])
                    matrix[i][j] = count++;
                visited[i][j] = true;
                i--;
            }
            minJ++;
            i++;
            j++;
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }

}
