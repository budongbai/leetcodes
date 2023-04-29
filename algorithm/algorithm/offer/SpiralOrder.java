package algorithm.offer;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows * cols];

        int minI = 0, maxI = rows - 1, minJ = 0, maxJ = cols - 1;

        int index = 0;
        while (minI <= maxI && minJ <= maxJ) {
            for (int j = minJ; j <= maxJ; j++) {
                result[index++] = matrix[minI][j];
            }
            for (int i = minI + 1; i <= maxI; i++) {
                result[index++] = matrix[i][maxJ];
            }
            if (minI < maxI && minJ < maxJ) {
                for (int j = maxJ - 1; j > minJ; j--) {
                    result[index++] = matrix[maxI][j];
                }
                for (int i = maxI; i > minI; i--) {
                    result[index++] = matrix[i][minJ];
                }
            }
            minJ++;
            minI++;
            maxI--;
            maxJ--;
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}};

        new SpiralOrder().spiralOrder(matrix);
    }
}
