package xiaomi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月18日下午8:15:00
 */
class Node {
    String content; // the character in the node
    int num;
    boolean isEnd; // whether the end of the words
    int count; // the number of words sharing this character
    LinkedList<Node> childList; // the child list

    public Node(String c, int n) {
        childList = new LinkedList<Node>();
        isEnd = false;
        content = c;
        count = 0;
        num = n;
    }

    public Node subNode(String c) {
        if (childList != null) {
            for (Node eachChild : childList) {
                if (eachChild.content.equals(c)) {
                    return eachChild;
                }
            }
        }
        return null;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node("", 0);
    }

    public void insert(String word, int n) {
        if (search(word) == n)
            return;

        Node current = root;
        String[] ss = word.substring(1).split("/");
        for (int i = 0; i < ss.length; i++) {
            Node child = current.subNode(ss[i]);
            if (child != null) {
                current = child;
            } else {
                current.childList.add(new Node(ss[i], n));
                current = current.subNode(ss[i]);
            }
            current.count++;
        }
        // Set isEnd to indicate end of the word
        current.isEnd = true;
    }

    public int search(String word) {
        Node current = root;
        String[] ss = word.substring(1).split("/");
        for (int i = 0; i < ss.length; i++) {
            if (current.subNode(ss[i]) == null)
                return current.num;
            else
                current = current.subNode(ss[i]);
        }

        if (current.isEnd == true)
            return current.num;
        else
            return 0;
    }

}

public class Main2 {

    public static void main(String[] args) {


        Trie trie = new Trie();

        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        while (!line.equals("-")) {
            String[] ss = line.split("\\s+");

            trie.insert(ss[0], Integer.parseInt(ss[1]));
            line = scan.nextLine();
        }

        while (scan.hasNextLine()) {
            System.out.println(trie.search(scan.nextLine()));
        }
        scan.close();
    }

}
