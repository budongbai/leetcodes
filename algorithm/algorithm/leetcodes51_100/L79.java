package algorithm.leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月24日下午7:04:52
 */
public class L79 {

    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        //一旦越界或者无法与字符串相应位置的字符匹配或者已经访问过，返回false
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
            || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        //搜索上下左右是否有这么一个字母，有一个就行
        if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
            || search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    //不需额外空间存储，巧妙地运用了异或操作，对于访问过的字符，通过异或来表示它被访问过，再异或恢复原值
    public boolean exist2(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        //System.out.println(board[y][x]);
        board[y][x] ^= 256;
        //System.out.println(board[y][x]);
        boolean exist = exist(board, y, x + 1, word, i + 1)
            || exist(board, y, x - 1, word, i + 1)
            || exist(board, y + 1, x, word, i + 1)
            || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        //System.out.println(board[y][x]);
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        L79 test = new L79();
        String word = "ABCCED";
        boolean res = test.exist2(board, word);
        System.out.println(res);
    }
}
