package algorithm.leetcodes101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author budongbai
 * @version 2017年6月24日下午9:45:33
 */

// Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class L138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode node = head;
        while (node.next != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node.next != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);

    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }
        //第一遍扫描：把新节点放在原节点后面
        RandomListNode p = head;
        while (p != null) {
            RandomListNode node = p.next;
            RandomListNode newnode = new RandomListNode(p.label);
            newnode.next = node;
            p.next = newnode;
            p = newnode.next;
        }
        //第二遍扫描：检查节点是否有random节点，有，就赋值
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        //第三遍：把新节点揪出来
        RandomListNode newhead = head.next;
        p = head;
        RandomListNode newnode;
        while (p != null) {
            newnode = p.next;
            p.next = newnode.next;
            if (newnode.next != null) {
                newnode.next = newnode.next.next;
            }
            p = p.next;
        }

        return newhead;
    }

    public RandomListNode copyRandomList3(RandomListNode head) {
        RandomListNode p = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (p != null) {
            next = p.next;

            RandomListNode copy = new RandomListNode(p.label);
            p.next = copy;
            copy.next = next;

            p = next;
        }

        // Second round: assign random pointers for the copy nodes.
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        p = head;
        RandomListNode pseudoHead = new RandomListNode(0);
        RandomListNode copy, copyIter = pseudoHead;

        while (p != null) {
            next = p.next.next;

            // extract the copy
            copy = p.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            p.next = next;

            p = next;
        }

        return pseudoHead.next;
    }

    public static void main(String[] args) {


    }

}
