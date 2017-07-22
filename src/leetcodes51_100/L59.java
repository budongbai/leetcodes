package leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月13日下午12:16:49
 */
public class L59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        // 行
        int rowBegin = 0, rowEnd = n - 1;
        // 列
        int colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            if (rowBegin == rowEnd && colBegin == colEnd) {
                res[rowBegin][colBegin] = count++;

            }
            for (int i = rowBegin; i < rowEnd; i++) {
                res[colBegin][i] = count++;
            }
            for (int i = colBegin; i < colEnd; i++) {
                res[i][rowEnd] = count++;
            }
            if (rowBegin < rowEnd) {
                for (int i = rowEnd; i > rowBegin; i--) {
                    res[colEnd][i] = count++;
                }
            }
            if (colBegin < colEnd) {
                for (int i = colEnd; i > colBegin; i--) {
                    res[i][rowBegin] = count++;
                }
            }
            colBegin++;
            rowBegin++;
            colEnd--;
            rowEnd--;
        }
        return res;
    }

    public static void main(String[] args) {

        L59 test = new L59();
        int[][] res = test.generateMatrix(5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
