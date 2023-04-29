package algorithm.leetcodes51_100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author budongbai
 * @version 2017年7月19日下午1:17:39
 */
public class L73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return;
        }
        Set<Integer> setI = new HashSet<Integer>();
        Set<Integer> setJ = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setI.add(i);
                    setJ.add(j);
                }
            }
        }
        //处理行
        for (Integer i : setI) {
            Arrays.fill(matrix[i], 0);
        }
        //处理列
        for (int j : setJ) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        boolean fr = false, fc = false;
        //利用matrix的第一行和第一列做标记，如果第一行或第一列值被设为0，则整行或整列设为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //单独处理第一个元素
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 4}, {1, 4, 5, 0}};
        L73 test = new L73();
        test.setZeroes2(matrix);
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
