package pinduoduo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月2日上午10:40:57
 */
class Node {
    int x;
    int y;
    int cnt;
    int sta;

    public Node() {
        this.cnt = 0;
        this.sta = 0;
    }

    public String toString() {
        return x + "/" + y;
    }
}

public class Main4 {
    public static Queue<Node> que = new LinkedList<Node>();
    public static int[] fx = {0, 0, 1, -1};
    public static int[] fy = {1, -1, 0, 0};

    public static int bfs(int sx, int sy, int ex, int ey, char[][] mz, int m, int n, Map<Character, Integer> keys, boolean[][][] visited) {
        while (!que.isEmpty()) que.poll();
        Node tmp = new Node();
        tmp.x = sx;
        tmp.y = sy;
        que.offer(tmp);
        while (!que.isEmpty()) {
            Node p = que.poll();
            //找到了出口
            if (p.x == ex && p.y == ey) {
                return p.cnt;
            }
            //分别向上下左右探路
            for (int i = 0; i < 4; ++i) {
                int newx = p.x + fx[i];
                int newy = p.y + fy[i];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n) continue;
                if (mz[newx][newy] == '0') continue;
                int sta = p.sta;
                if (mz[p.x][p.y] >= 'a' && mz[p.x][p.y] <= 'z') {
                    sta |= (1 << keys.get(mz[p.x][p.y]));
                }
                if (visited[newx][newy][sta]) continue;
                if (mz[newx][newy] >= 'A' && mz[newx][newy] <= 'Z') {
                    if ((sta & (1 << (keys.get((char) (mz[newx][newy] - 'A' + 'a'))))) == 0) {
                        continue;
                    }
                }
                visited[newx][newy][sta] = true;
                tmp = new Node();
                tmp.x = newx;
                tmp.y = newy;
                tmp.cnt = p.cnt + 1;
                tmp.sta = sta;
                que.offer(tmp);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        char[][] matrix = new char[m][n];
        boolean[][][] visited = new boolean[m][n][n * 10];
        scan.nextLine();
        int sx = 0, sy = 0, ex = 0, ey = 0;
        Map<Character, Integer> keys = new HashMap<Character, Integer>();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '2') {
                    sx = i;
                    sy = j;
                } else if (c == '3') {
                    ex = i;
                    ey = j;
                } else if (c >= 'a' && c <= 'z') {
                    keys.put(c, cnt++);
                }
                matrix[i][j] = c;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //cnt把钥匙，则对应了2^cnt种状态
                for (int k = 0; k < (1 << cnt); k++) {
                    visited[i][j][k] = false;
                }
            }
        }
        int res = bfs(sx, sy, ex, ey, matrix, m, n, keys, visited);
        System.out.println(res);
        scan.close();
    }

}
