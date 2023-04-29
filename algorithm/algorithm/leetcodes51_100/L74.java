package algorithm.leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月19日下午2:13:52
 */
public class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int end = m * n - 1;
        int start = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] > target) {
                end = mid - 1;
            } else if (matrix[i][j] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return res;
    }

    public boolean serachMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        L74 test = new L74();
        boolean res = test.searchMatrix(matrix, 12);
        System.out.println(res);
    }
}
