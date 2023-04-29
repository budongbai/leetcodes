package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月11日下午2:51:13
 */
public class L48 {
    public void rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix.length];
        int m = 0, n = 0;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length - 1; i >= 0; i--) {

                res[m][n] = matrix[i][j];
                n++;
            }
            n = 0;
            m++;
        }
        for (int i = 0; i < matrix.length; i++) {
            //System.out.println(Arrays.toString(res[i]));
            matrix[i] = res[i];
        }
    }

    public void rotate2(int[][] matrix) {
        // 先对角线翻转
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 水平翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        L48 test = new L48();
        test.rotate2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
