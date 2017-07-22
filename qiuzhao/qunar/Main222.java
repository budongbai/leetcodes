package qunar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {

    /**
     * 节点名称(A,B,C,D)
     */
    private String name;

    /**
     * 最短路径长度
     */
    private int path;

    /**
     * 节点是否已经出列(是否已经处理完毕)
     */
    private boolean isMarked;

    public Vertex(String name) {
        this.name = name;
        this.path = Integer.MAX_VALUE; //初始设置为无穷大
        this.setMarked(false);
    }

    public Vertex(String name, int path) {
        this.name = name;
        this.path = path;
        this.setMarked(false);
    }

    public void setMarked(boolean b) {

        this.isMarked = b;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }


    @Override
    public int compareTo(Vertex o) {
        return o.path > path ? -1 : 1;
    }

    public boolean isMarked() {

        return this.isMarked;
    }
}

class Graph {
    public static final int MAX = 10000;
    /*
     * 顶点
     */
    private List<Vertex> vertexs;

    /*
     * 边
     */
    private int[][] edges;

    /*
     * 没有访问的顶点
     */
    private Queue<Vertex> unVisited;

    public Graph(List<Vertex> vertexs, int[][] edges) {
        this.vertexs = vertexs;
        this.edges = edges;
        initUnVisited();
    }

    /*
     * 搜索各顶点最短路径
     */
    public void search() {
        while (!unVisited.isEmpty()) {
            Vertex vertex = unVisited.element();
            //顶点已经计算出最短路径，设置为"已访问"
            vertex.setMarked(true);
            //获取所有"未访问"的邻居
            List<Vertex> neighbors = getNeighbors(vertex);
            //更新邻居的最短路径
            updatesDistance(vertex, neighbors);
            pop();
        }
        // System.out.println("search over");
    }

    /*
     * 更新所有邻居的最短路径
     */
    private void updatesDistance(Vertex vertex, List<Vertex> neighbors) {
        for (Vertex neighbor : neighbors) {
            updateDistance(vertex, neighbor);
        }
    }

    /*
     * 更新邻居的最短路径
     */
    private void updateDistance(Vertex vertex, Vertex neighbor) {
        if (getDistance(vertex, neighbor) < Integer.MAX_VALUE) {
            int distance = getDistance(vertex, neighbor) + vertex.getPath();
            if (distance < neighbor.getPath()) {
                neighbor.setPath(distance);
            }
        }

    }

    /*
     * 初始化未访问顶点集合
     */
    private void initUnVisited() {
        unVisited = new PriorityQueue<Vertex>();
        for (Vertex v : vertexs) {
            unVisited.add(v);
        }
    }

    /*
     * 从未访问顶点集合中删除已找到最短路径的节点
     */
    private void pop() {
        unVisited.poll();
    }

    /*
     * 获取顶点到目标顶点的距离
     */
    int getDistance(Vertex source, Vertex destination) {
        int sourceIndex = vertexs.indexOf(source);
        int destIndex = vertexs.indexOf(destination);
        return edges[sourceIndex][destIndex];
    }

    /*
     * 获取顶点所有(未访问的)邻居
     */
    private List<Vertex> getNeighbors(Vertex v) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        int position = vertexs.indexOf(v);
        Vertex neighbor = null;
        int distance;
        for (int i = 0; i < vertexs.size(); i++) {
            if (i == position) {
                //顶点本身，跳过
                continue;
            }
            distance = edges[position][i];    //到所有顶点的距离
            if (distance < Integer.MAX_VALUE) {
                //是邻居(有路径可达)
                neighbor = getVertex(i);
                if (!neighbor.isMarked()) {
                    //如果邻居没有访问过，则加入list;
                    neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }

    /*
     * 根据顶点位置获取顶点
     */
    private Vertex getVertex(int index) {
        return vertexs.get(index);
    }

    /*
     * 打印图
     */
    public void printGraph() {
        int verNums = vertexs.size();
        for (int row = 0; row < verNums; row++) {
            for (int col = 0; col < verNums; col++) {
                if (MAX == edges[row][col]) {
                    System.out.print("X");
                    System.out.print(" ");
                    continue;
                }
                System.out.print(edges[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}

public class Main222 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 人的个数
        int graphSize = scan.nextInt();
        List<Vertex> vertexs = new ArrayList<Vertex>();
        int[][] graph = new int[graphSize][graphSize];
        // 关系的个数
        int edgeSize = scan.nextInt();
        HashMap<String, Integer> people = new HashMap<String, Integer>();

        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < edgeSize; i++) {
            // System.out.println("输入边的起点、终点和权值：");
            String fromP = scan.next();
            String toP = scan.next();
            int from, to;
            if (!people.containsKey(fromP)) {
                from = count;
                vertexs.add(new Vertex(fromP));
                people.put(fromP, count++);
            } else {
                from = people.get(fromP);
            }
            if (!people.containsKey(toP)) {
                to = count;
                vertexs.add(new Vertex(toP));
                people.put(toP, count++);
            } else {
                to = people.get(toP);
            }
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        Graph g = new Graph(vertexs, graph);
        g.search();
        int max = 0;
        for (int i = 0; i < vertexs.size(); i++) {
            int p = vertexs.get(i).getPath();
            System.out.println(p);
            if (p < Integer.MAX_VALUE)
                max = max < p ? p : max;
        }
        System.out.println(max);
    }
}