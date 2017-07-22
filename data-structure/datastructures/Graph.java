package datastructures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author budongbai
 * @version 2017年5月11日下午3:22:15
 */

class Edge {
    int verAdj; // 邻接顶点序号，从0开始编号
    int cost; // 边的权值
    Edge next; // 下一个边结点

    public Edge(int verAdj, int cost) {
        this.verAdj = verAdj;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Edge [verAdj=" + verAdj + ", cost=" + cost + ", Edge=" + next + "]";
    }

}

class Vertex {
    int verName; // 顶点的名称
    Edge adjacent;// 边链表的头结点

    public Vertex(int verName) {
        this.verName = verName;
        this.adjacent = null;
    }

    @Override
    public String toString() {
        return "Vertex [verName=" + verName + ", adjacent=" + adjacent + "]";
    }
}

public class Graph {
    Vertex[] head; // 顶点表头指针
    int graphSize; // 图中当前顶点的个数

    public Graph(Vertex[] head, int graphSize) {
        this.head = head;
        this.graphSize = graphSize;
    }

    public static Graph initGraph() {

        Scanner scan = new Scanner(System.in);
        // System.out.println("输入顶点的个数：");
        int graphSize = scan.nextInt();

        // 初始化
        Vertex[] head = new Vertex[graphSize];
        for (int i = 0; i < graphSize; i++) {
            head[i] = new Vertex(i);
        }
        Graph graph = new Graph(head, graphSize);
        // System.out.println("输入边的个数：");
        int edgeSize = scan.nextInt();
        for (int i = 0; i < edgeSize; i++) {
            // System.out.println("输入边的起点、终点和权值：");
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            if (head[from].adjacent == null) {
                head[from].adjacent = new Edge(to, cost);
            } else {
                Edge e = head[from].adjacent;
                while (e.next != null) {
                    e = e.next;
                }
                e.next = new Edge(to, cost);
            }
        }
        return graph;
    }

    public int getFirstNext(int verName) {
        Edge e = head[verName].adjacent;
        return e == null ? -1 : e.verAdj;
    }

    public int getNext(int v, int w) {
        Edge e = head[v].adjacent;
        while (e.verAdj != w && e.next != null) {
            e = e.next;
        }
        return e.next == null ? -1 : e.next.verAdj;
    }

    public void dfs() {
        int[] visited = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            visited[i] = 0;
        }
        dfs(0, visited);
    }

    private void dfs(int v, int[] visited) {
        System.out.print(v + " ");
        visited[v] = 1;
        int w = getFirstNext(v);// 取得verName的第一个邻接顶点的序号
        while (w != -1) {
            if (visited[w] == 0) {
                dfs(w, visited);
            }
            w = getNext(v, w);
        }
    }

    public void dfsIterator() {
        Stack<Integer> stack = new Stack<Integer>();
        int[] visited = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            visited[i] = 0;
        }
        stack.push(0);
        visited[0] = 1;
        while (!stack.isEmpty()) {
            int v = (int) stack.pop();
            System.out.print(v + " ");
            int p = getFirstNext(v);
            while (p != -1) {
                if (visited[p] == 0) {
                    stack.push(p);
                    visited[p] = 1;
                }
                p = getNext(v, p);

            }
        }
    }

    public void bfsIterator() {
        Deque<Integer> deque = new LinkedList<Integer>();

        int[] visited = new int[graphSize];
        for (int i = 0; i < graphSize; i++) {
            visited[i] = 0;
        }
        System.out.print(0 + " ");
        deque.offer(0);
        //System.out.println(deque);
        while (!deque.isEmpty()) {
            int v = (int) deque.poll();
            //System.out.println(deque);

            int p = getFirstNext(v);
            while (p != -1) {
                if (visited[p] == 0) {
                    System.out.print(p + " ");
                    deque.offer(p);
                    //System.out.println(deque);
                    visited[p] = 1;
                }
                p = getNext(v, p);

            }
        }

    }

    public void topoOrder() {
        int n = graphSize;
        int[] count = new int[n];
        //count数组存储的是顶点的入度。
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            Edge p = head[i].adjacent;
            while (p != null) {
                count[p.verAdj]++;
                p = p.next;
            }
        }

        int top = -1;
        for (int i = 0; i < n; i++) {
            //入度为0的顶点入栈
            if (count[i] == 0) {
                count[i] = top;
                top = i;
            }
        }
        for (int i = 0; i < n; i++) {
            //若循环体尚未被执行n次，栈顶指针已为 -1， 说明有回路，终止程序；
            if (top == -1) {
                System.out.println("图中有环");
                return;
            } else {
                int j = top;
                top = count[top];//从栈中弹出一个顶点j
                System.out.print(j + " ");
                Edge p = head[j].adjacent;
                while (p != null) {
                    int k = p.verAdj;
                    if (--count[k] == 0) {
                        count[k] = top;
                        top = k;
                    }
                    p = p.next;

                }
            }

        }
    }

    @Override
    public String toString() {
        String r = "Graph [graphSize= " + graphSize + ",head=\n";
        for (int i = 0; i < head.length; i++) {
            r += head[i] + "\n";
        }
        return r;
    }

    public static void main(String[] args) {

        // 9 10 0 1 3 1 2 6 1 4 5 0 3 2 2 5 1 2 6 3 4 6 2 5 7 4 6 7 3 7 8 9
        Graph graph = initGraph();
        System.out.println(graph);
        graph.dfs();
        System.out.println();
        graph.dfsIterator();
        System.out.println();
        graph.bfsIterator();
        System.out.println();
        graph.topoOrder();
    }

}
