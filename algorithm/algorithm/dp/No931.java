

package algorithm.dp;

public class No931 {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int res = Integer.MAX_VALUE;

        for(int j =0; j< n; j++){
            res = Math.min(res, dp(matrix, n-1, j));
        }

        return res;
    }

    private int dp(int[][] matrix, int i, int j) {
        if(i< 0 || j < 0 || i >= matrix.length || j >= matrix[0].length){
            return 99999;
        }

        if(i == 0){
            return matrix[i][j];
        }

        return matrix[i][j] + Math.min(
            dp(matrix, i - 1, j - 1),
            Math.min(dp(matrix, i - 1, j),
                dp(matrix, i - 1, j + 1)))
            ;
    }
}
