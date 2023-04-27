package leetcodes101_150;

import java.util.LinkedList;

public class L1091 {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int res = 0, n = grid.length;
        // 存放当前元素的下标
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        // 枚举8个方向
        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            res++;
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                int[] t = queue.pollFirst();
                // 如果在广度优先遍历种先到达了终点
                if (t[0] == n - 1 && t[1] == n - 1) return res;
                // 分别往8个方向走
                for (int[] d : dir) {
                    int x = t[0] + d[0], y = t[1] + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n
                        && grid[x][y] == 0 && !vis[x][y]) {
                        vis[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{0,0,1,0},{1,1,1,0},{1,1,0,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
