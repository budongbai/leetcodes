package algorithm.leetcodes51_100;

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

    /**
     * https://leetcode.cn/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
     *
     * 优雅实在是太优雅了
     */
    public int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {

        L59 test = new L59();
        int[][] res = test.generateMatrix(5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
