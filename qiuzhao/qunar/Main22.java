package qunar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月14日上午9:55:58
 */
public class Main22 {
    public static final int MAXINT = 32767;
    public static final int MAXNUM = 50;
    //public static int[] dist = new int[MAXNUM];
    public static int[] prev = new int[MAXNUM];


    public static int[] dijkstra(int[][] graph, int v0, int n) {
        int[] dist = new int[MAXNUM];
        boolean[] flag = new boolean[MAXNUM]; // 判断是否已存入该点到S集合中
        //int n = MAXNUM;
        for (int i = 1; i <= n; ++i) {
            dist[i] = graph[v0][i];
            flag[i] = false; // 初始都未用过该点
            if (dist[i] == MAXINT)
                prev[i] = -1;
            else
                prev[i] = v0;
        }
        dist[v0] = 0;
        flag[v0] = true;
        for (int i = 2; i <= n; i++) {
            int mindist = MAXINT;
            int u = v0; // 找出当前未使用的点j的dist[j]最小值
            for (int j = 1; j <= n; ++j)
                if ((!flag[j]) && dist[j] < mindist) {
                    u = j; // u保存当前邻接点中距离最小的点的号码
                    mindist = dist[j];
                }
            flag[u] = true;
            for (int j = 1; j <= n; j++)
                if ((!flag[j]) && graph[u][j] < MAXINT) {
                    if (dist[u] + graph[u][j] < dist[j]) // 在通过新加入的u点路径找到离v0点更短的路径
                    {
                        dist[j] = dist[u] + graph[u][j]; // 更新dist
                        prev[j] = u; // 记录前驱顶点
                    }
                }
        }
        return dist;
    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        // 人的个数
        int graphSize = scan.nextInt();
        // 关系的个数
        int edgeSize = scan.nextInt();
        int[][] graph = new int[graphSize][graphSize];
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        int count = 0;
        for (int i = 0; i < edgeSize; i++) {
            // System.out.println("输入边的起点、终点和权值：");
            String fromP = scan.next();
            String toP = scan.next();
            int from, to;
            if (!people.containsKey(fromP)) {
                from = count;
                people.put(fromP, count++);
            } else {
                from = people.get(fromP);
            }
            if (!people.containsKey(toP)) {
                to = count;
                people.put(toP, count++);
            } else {
                to = people.get(toP);
            }
            graph[from][to] = 1;
            graph[to][from] = 1;

        }
        int[] dist = dijkstra(graph, 0, graphSize);
        System.out.println(Arrays.toString(dist));
        for (int i = 0; i < graphSize; i++) {

        }

    }

}
