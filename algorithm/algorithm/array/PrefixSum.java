package algorithm.array;

/**
 * 前缀和
 *
 * <a href="https://leetcode.cn/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/">...</a>
 */
public class PrefixSum {

    /**
     * <a href="https://leetcode.cn/problems/range-sum-query-immutable/">303. 区域和检索 - 数组不可变</a>
     */
    class NumArray {
        private final int[] preSums;

        public NumArray(int[] nums) {
            this.preSums = new int[nums.length + 1];
            for (int i = 1; i < preSums.length; i++) {
                preSums[i] = preSums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return preSums[right + 1] - preSums[left];
        }
    }

    /**
     * <a href="https://leetcode.cn/problems/range-sum-query-2d-immutable/">304. 二维区域和检索 - 矩阵不可变</a>
     */
    class NumMatrix {
        private final int[][] preMatrix;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            this.preMatrix = new int[m + 1][n + 1];
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    // 计算矩阵[0,0,i,j]的和
                    preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] + matrix[i - 1][j - 1] - preMatrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preMatrix[row2 + 1][col2 + 1] - preMatrix[row2 + 1][col1] - preMatrix[row1][col2 + 1] + preMatrix[row1][col1];
        }
    }
}
