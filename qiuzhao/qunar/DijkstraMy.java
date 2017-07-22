package qunar;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月14日上午10:09:32
 */

public class DijkstraMy {
    // 顶点总个数
    int total;
    // 邻接矩阵表示距离
    int[][] matrix;
    // 结点相关信息
    String[] nodes;
    // 存储最后结果
    int[] dis;
    // 标记结点
    int[] mark;

    DijkstraMy(int total, String[] nodes) {
        this.total = total;
        this.nodes = nodes;
        this.matrix = new int[total][total];
        this.dis = new int[total];
        this.mark = new int[total];
    }

    private static DijkstraMy initMatrix() {
        Scanner scan = new Scanner(System.in);
        // 人的个数
        int graphSize = scan.nextInt();
        String[] nodes = new String[graphSize];
        DijkstraMy graph = new DijkstraMy(graphSize, nodes);
        // 关系的个数
        int edgeSize = scan.nextInt();
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        int count = 0;
        for (int i = 0; i < edgeSize; i++) {
            // System.out.println("输入边的起点、终点和权值：");
            String fromP = scan.next();
            String toP = scan.next();
            int from, to;
            if (!people.containsKey(fromP)) {
                from = count;
                nodes[count] = fromP;
                people.put(fromP, count++);
            } else {
                from = people.get(fromP);
            }
            if (!people.containsKey(toP)) {
                to = count;
                nodes[count] = toP;
                people.put(toP, count++);
            } else {
                to = people.get(toP);
            }
            graph.matrix[from][to] = 1;
            graph.matrix[to][from] = 1;
        }
        return graph;
    }

    private void printMatrix() {

        for (int i = 0; i < this.total; i++) {
            System.out.print("-" + this.nodes[i] + "|");
            for (int j = 0; j < this.total; j++) {
                System.out.print(String.format("%03d", this.matrix[i][j]) + "-");
            }
            System.out.print("\n");
        }
        System.out.println("--------- weighted directed matrix ---------");
    }

    private void dijkstra1(int s) {
        for (int i = 0; i < total; i++)
            mark[i] = 0;
        mark[s] = 1;
        for (int i = 0; i < total; i++) {
            dis[i] = matrix[s][i];
        }
        /** 每次找到一个最小值，标记，然后修改其相邻的值 */
        for (int i = 0; i < total; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < total; j++) {
                if (mark[j] == 0 && dis[j] < min) {
                    index = j;
                    min = matrix[s][j];
                }
            }
            if (index == -1)
                return;
            mark[index] = 1;
            for (int k = 0; k < total; k++) {
                if (mark[k] == 0 && dis[index] + matrix[index][k] < dis[k]) {
                    dis[k] = dis[index] + matrix[index][k];
                }
            }
            printDis(0, this.nodes[i], "第" + i + "次");
        }
    }


    private void printDis(int i, String node, String pre) {
        /*
         * System.out.print("\n" + pre + "," + node + "," + i + "--->"); for
         * (int t = 0; t < this.dis.length; t++) { System.out.print(t + ","); }
         */
        System.out.print("\n" + pre + i + "--->");
        for (int t : this.dis) {
            System.out.print(t + ",");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        //String[] nodes = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
        //DijkstraMy dij = new DijkstraMy(nodes.length, nodes);
        DijkstraMy graph = initMatrix();
        graph.printMatrix();

        System.out.println();
        System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之迭代开始 ------");
        graph.dijkstra1(0);
        graph.printDis(0, "迭代结果", "最终值");
        graph.dijkstra1(1);
        graph.printDis(1, "迭代结果", "最终值");
        graph.dijkstra1(2);
        graph.printDis(2, "迭代结果", "最终值");
        graph.dijkstra1(3);
        graph.printDis(3, "迭代结果", "最终值");
        System.out.print("\n");
        System.out.println("------ Dijkstra算法-(迪杰斯特拉)算法之迭代结束 ------");

    }
}
