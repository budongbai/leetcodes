package qiyi;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author budongbai
 * @version 2017年5月14日下午9:12:03
 */
class Vertex {

	boolean wasVisited; // 是否遍历过
	public char label; // 节点名称
	ArrayList<Integer> allVisitedList;// 节点已访问过的顶点

	public void setAllVisitedList(ArrayList<Integer> allVisitedList) {
		this.allVisitedList = allVisitedList;
	}

	public ArrayList<Integer> getAllVisitedList() {
		return allVisitedList;
	}

	public boolean WasVisited() {
		return wasVisited;
	}

	public void setWasVisited(boolean wasVisited) {
		this.wasVisited = wasVisited;
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public Vertex(char lab) // constructor
	{
		label = lab;
		wasVisited = false;
	}

	public void setVisited(int j) {
		allVisitedList.set(j, 1);

	}

}

class Graph {

	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix

	private int nVerts;
	private static int MAX_VERTS = 7; // n个点

	int i = 0;
	int j = 0;

	public Vertex[] getVertexList() {
		return vertexList;
	}

	public int[][] getAdjMat() {
		return adjMat;
	}

	public int getN() {
		return MAX_VERTS;
	}

	public Graph(int index) {
		adjMat = new int[MAX_VERTS][MAX_VERTS]; // 邻接矩阵
		vertexList = new Vertex[MAX_VERTS]; // 顶点数组
		nVerts = 0;

		for (i = 0; i < MAX_VERTS; i++) {
			for (j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}

		addVertex('A');
		addVertex('B');
		addVertex('C');
		addVertex('D');
		addVertex('E');
		addVertex('F');
		addVertex('G');

		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 4);
		addEdge(2, 0);
		addEdge(2, 5);
		addEdge(3, 0);
		addEdge(3, 2);
		addEdge(3, 3);
		addEdge(4, 1);
		addEdge(4, 2);
		addEdge(5, 6);
		addEdge(6, 3);

		switch (index) {
		case 0:
			break;
		case 1:
			delEdge(4, 2);
			break;
		default:
			break;
		}
	}

	private void delEdge(int start, int end) {
		adjMat[start][end] = 0;
	}

	private void addEdge(int start, int end) {// 有向图，添加边
		adjMat[start][end] = 1;
		// adjMat[end][start] = 1;
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);// 添加点
	}

	public char displayVertex(int i) {
		return vertexList[i].getLabel();
	}

	public boolean displayVertexVisited(int i) {
		return vertexList[i].WasVisited();
	}

	public void printGraph() {
		for (i = 0; i < MAX_VERTS; i++) {
			System.out.print("第" + displayVertex(i) + "个节点:" + " ");

			for (j = 0; j < MAX_VERTS; j++) {
				System.out.print(displayVertex(i) + "-" + displayVertex(j) + "：" + adjMat[i][j] + " ");
			}
			System.out.println();
		}

	}

}

public class QiYi04 {
	boolean isAF = true;
	Graph graph;
	int n;
	int start, end;
	Stack<Integer> theStack;

	private ArrayList<Integer> tempList;
	private String counterexample;

	public QiYi04(Graph graph, int start, int end) {
		this.graph = graph;
		this.start = start;
		this.end = end;
	}

	public boolean getResult() {
		graph.printGraph();
		//获取顶点个数
		n = graph.getN();
		theStack = new Stack<Integer>();
		
		if (!isConnectable(start, end)) {
			isAF = false;
			counterexample = "节点之间没有通路";
		} else {
			for (int j = 0; j < n; j++) {
				tempList = new ArrayList<Integer>();
				for (int i = 0; i < n; i++) {
					tempList.add(0);
				}
				
				//设置节点j的所有邻接点是否被访问过，初始化为0，均未被访问过
				graph.getVertexList()[j].setAllVisitedList(tempList);
			}
			isAF = af(start, end);
		}
		return isAF;
	}

	private boolean af(int start, int end) {
		graph.getVertexList()[start].setWasVisited(true); // mark it
		theStack.push(start); // push it
		while (!theStack.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // if no such vertex,
			{
				tempList = new ArrayList<Integer>();
				for (int j = 0; j < n; j++) {
					tempList.add(0);
				}
				graph.getVertexList()[theStack.peek()].setAllVisitedList(tempList);// 把栈顶节点访问过的节点链表清空
				theStack.pop();
			} else // if it exists,
			{
				theStack.push(v); // push it
			}
			if (!theStack.isEmpty() && end == theStack.peek()) {
				graph.getVertexList()[end].setWasVisited(false); // mark it
				printTheStack(theStack);
				System.out.println();
				theStack.pop();
			}
		}

		return isAF;
	}

	// 判断两个节点是否能连通
	private boolean isConnectable(int start, int end) {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			for (int j = 0; j < n; j++) {
				if (graph.getAdjMat()[start][j] == 1 && !visited.contains(j)) {
					queue.add(j);
				}
			}
			if (queue.contains(end)) {
				return true;
			} else {
				visited.add(queue.get(0));
				queue.remove(0);
				if (!queue.isEmpty()) {
					start = queue.get(0);
				}
			}
			
		}
		return false;
	}

	public String counterexample() {
		for (Integer integer : theStack) {
			counterexample += graph.displayVertex(integer);
			if (integer != theStack.peek()) {
				counterexample += "-->";
			}
		}

		return counterexample;
	}

	// 与节点v相邻，并且这个节点没有被访问到，并且这个节点不在栈中
	public int getAdjUnvisitedVertex(int v) {
		ArrayList<Integer> arrayList = graph.getVertexList()[v].getAllVisitedList();
		for (int j = 0; j < n; j++) {
			if (graph.getAdjMat()[v][j] == 1 && arrayList.get(j) == 0 && !theStack.contains(j)) {
				graph.getVertexList()[v].setVisited(j);
				return j;
			}
		}
		return -1;
	} // end getAdjUnvisitedVertex()

	/**
	 * Stack继承自Vector，Vector实现了List，所以Stack的内部结构其实是使用List来存储的。
	 * @author budongbai
	 * @version 2017年5月18日上午9:21:02
	 * @param theStack2
	 */
	public void printTheStack(Stack<Integer> theStack2) {
		for (Integer integer : theStack2) {
			System.out.print(graph.displayVertex(integer));
			if (integer != theStack2.peek()) {
				System.out.print("-->");
			}
		}

	}

	public static void main(String[] args) {
		// 第几张图，有两张(0,1)，起点序号(0-6)，终点序号(0-6)
		QiYi04 operation = new QiYi04(new Graph(0), 3, 6);
		operation.getResult();

	}
}
