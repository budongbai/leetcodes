package algorithm.leetcodes101_150;

class Solution {
    private static final int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        if (k == 1) {
            return 1;
        }

        int row = pizza.length;
        int col = pizza[0].length();
        int[][] map = new int[row + 1][col + 1];
        // map[i][j] 表示从i,j开始到最后的区域里面 有多少水果
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                map[i][j] = map[i + 1][j] + map[i][j + 1] - map[i + 1][j + 1];

                if (pizza[i].charAt(j) == 'A') {
                    map[i][j]++;
                }
            }
        }

        int[][][] dp = new int[k][row][col];
        dp[0][0][0] = 1;

        for (int n = 1; n < k; n++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int count = 0;
                    // j不变，横着切
                    for (int l = 0; l < i; l++) {
                        int flag = map[l][j] - map[i][j];
                        if (flag != 0 && map[i][j] != 0) {
                            count += dp[n - 1][l][j];
                            count %= MOD;
                        }
                    }
                    // i不变，竖着切
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
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res += dp[k - 1][i][j];
                res %= MOD;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String[] pizza = {"A..", "AAA", "..."};
        System.out.println(new Solution().ways(pizza, 3));
    }
}