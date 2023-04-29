package algorithm.offer;

public class PathInMatrix {
    boolean[][] visited;

    int pathLength = 0;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix char字符型二维数组
     * @param word   string字符串
     * @return bool布尔型
     */
    public boolean hasPath(char[][] matrix, String word) {
        if (matrix == null || matrix.length == 0 || word == null) {
            return false;
        }
        visited = new boolean[matrix.length][matrix[0].length];


        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, i, j, rows, cols, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[][] matrix, int i, int j, int rows, int cols, String word) {
        if (pathLength == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (i < rows && j < cols && i >= 0 && j >= 0
            && word.charAt(pathLength) == matrix[i][j]
            && !visited[i][j]) {

            pathLength++;

            visited[i][j] = true;

            hasPath = hasPathCore(matrix, i - 1, j, rows, cols, word) ||
                hasPathCore(matrix, i, j - 1, rows, cols, word) ||
                hasPathCore(matrix, i + 1, j, rows, cols, word) ||
                hasPathCore(matrix, i, j + 1, rows, cols, word);

            if (!hasPath) {
                pathLength--;
                visited[i][j] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        PathInMatrix demo = new PathInMatrix();
        System.out.println(demo.hasPath(matrix, "abcced"));
    }
}
