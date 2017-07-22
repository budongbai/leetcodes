package leetcodes51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年7月12日下午2:06:53
 */
public class L54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int maxI = matrix.length, minI = 0;
        if (maxI == 0) return res;
        int maxJ = matrix[0].length, minJ = 0;

        int i = 0, j = 0;
        boolean[][] visited = new boolean[maxI][maxJ];

        int count = 0;//用来计数是否到了最后。
        while (count < matrix.length * (matrix[0].length)) {
            while (j < maxJ) {
                if (!visited[i][j])
                    res.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
                j++;
            }
            maxJ--;
            j--;
            i++;
            while (i < maxI) {
                if (!visited[i][j])
                    res.add(matrix[i][j]);
                visited[i][j] = true;
                count++;
                i++;
            }
            maxI--;
            i--;
            j--;
            while (j >= minJ) {
                if (!visited[i][j])
                    res.add(matrix[i][j]);
                visited[i][j] = true;
                j--;
                count++;
            }

            minI++;
            j++;
            i--;
            while (i >= minI) {
                if (!visited[i][j])
                    res.add(matrix[i][j]);
                visited[i][j] = true;
                i--;
                count++;
            }
            minJ++;
            i++;
            j++;
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }

    public static void main(String[] args) {

        L54 test = new L54();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(test.spiralOrder(matrix));
    }

}
