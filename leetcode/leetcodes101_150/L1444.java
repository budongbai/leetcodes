package leetcodes101_150;

public class L1444 {
    public int ways(String[] pizza, int k) {
        if (k == 1) {
            return 1;
        }
        int row = pizza.length;
        int col = pizza[0].length();

        char[][] array = new char[row][col];

        for (int i = 0; i < row; i++) {
            array[i] = pizza[i].toCharArray();
        }
        return ways(array, 0, 0, k - 1);
    }

    private int ways(char[][] pizza, int row, int col, int remain) {
        if (remain == 0) {
            if (hasApple(pizza, row, col)) {
                return 1;
            }
            return 0;
        }

        int count = 0;
        int firstRow = findFirstRow(pizza, row, col);
        if (firstRow != -1) {
            for (int i = firstRow; i < pizza.length; i++) {
                count += ways(pizza, i + 1, col, remain - 1);
            }
        }


        int firstCol = findFirstCol(pizza, row, col);

        if (firstCol != -1) {
            for (int j = firstCol; j < pizza[0].length; j++) {
                count += ways(pizza, row, j + 1, remain - 1);
            }

        }
        return count;
    }

    private boolean hasApple(char[][] pizza, int row, int col) {
        for (int i = row; i < pizza.length; i++) {
            for (int j = col; j < pizza[0].length; j++) {
                if (pizza[i][j] == 'A') {
                    return true;
                }
            }
        }
        return false;
    }


    private int findFirstRow(char[][] pizza, int row, int col) {
        for (int i = row; i < pizza.length; i++) {
            for (int j = col; j < pizza[0].length; j++) {
                if (pizza[i][j] == 'A') {
                    return i;
                }
            }
        }
        return -1;
    }

    private int findFirstCol(char[][] pizza, int row, int col) {
        for (int j = col; j < pizza[0].length; j++) {
            for (int i = row; i < pizza.length; i++) {
                if (pizza[i][j] == 'A') {
                    return j;
                }
            }
        }
        return -1;
    }

    public final int MOD = 1000000007;

    public int ways2(String[] pizza, int k) {
        int rol = pizza.length;
        int col = pizza[0].length();
        // map[i][j] 表示从i,j开始到最后的区域里面 有多少水果
        int[][] map = new int[rol + 1][col + 1];
        for (int i = rol - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                map[i][j] = map[i + 1][j] + map[i][j + 1] - map[i + 1][j + 1];

                if (pizza[i].charAt(j) == 'A') {
                    map[i][j]++;
                }
            }
        }
        int[][][] dp = new int[k][rol][col];
        dp[0][0][0] = 1;
        // dp[k][i][j] 表示切了k次，剩下区域是i,j的可行方案有多少种
        // 在方案能行的情况下 dp[n][i][j]有2个来源 最后一道横着切或者竖着切
        // 横着切 dp[n][i][j] = (dp[n-1][0][j] + dp[n-1][1][j] + dp[n-1][2][j] +...dp[n-1][i-1][j]);
        // 如果方案可行的话
        // 同理竖着切....
        for (int n = 1; n < k; n++) {   //切n次
            for (int i = 0; i < rol; i++) {
                for (int j = 0; j < col; j++) {
                    //剩下i , j
                    int count = 0;
                    for (int l = 0; l < i; l++) {   //j不变
                        int flag = map[l][j] - map[i][j];
                        if (flag != 0 && map[i][j] != 0) {
                            count += dp[n - 1][l][j];
                            count %= MOD;
                        }
                    }
                    for (int l = 0; l < j; l++) {
                        int flag = map[i][l] - map[i][j];
                        if (flag != 0 && map[i][j] != 0) {
                            count += dp[n - 1][i][l];
                            count %= MOD;
                        }
                    }
                    dp[n][i][j] = count;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < rol; i++) {
            for (int j = 0; j < col; j++) {
                res += dp[k - 1][i][j];
                res %= MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] pizza = {"A..", "AAA", "..."};
        System.out.println(new L1444().ways2(pizza, 3));
    }
}
