package pinduoduo2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月2日下午3:05:09
 */

class Node {
    public String name;
    public int level;
    List<Node> list;
    int count = 0;

    public Node(String name, int level) {
        this.name = name;
        this.level = level;
        this.list = new ArrayList<Node>();
    }
}

public class Main1 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        LinkedList<Node> list = new LinkedList<Node>();


        for (int i = 0; i < n; i++) {
            String name = scan.next();
            int level = scan.nextInt();
            Node node = new Node(name, level);
            Node last = null;
            if (list.size() == 0) {
                list.push(node);
            } else {
                last = list.peek();
            }

        }
        String p1 = "|--";
        String p2 = "`--";
        String name = scan.next();
        int level = scan.nextInt();

        System.out.println(name);
        int count = 0;
        int num = 0;
        for (int i = 1; i < n; i++) {
            String curName = scan.next();
            int curLevel = scan.nextInt();

            if (curLevel > level) {

                for (int j = 0; j < count; j++) {
                    System.out.print("|   ");
                }
                System.out.println(p1 + curName);
                count++;
            } else {

                System.out.println(p1 + curName);
                count = 0;
            }
            level = curLevel;
            name = curName;

        }


    }

}
