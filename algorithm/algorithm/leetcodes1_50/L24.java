package algorithm.leetcodes1_50;

import helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年7月4日下午8:59:13
 */
public class L24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //用了四个指针来标记位置，last标记当前节点的前节点，p1标记当前节点，p2标记当前节点next节点的next节点
        //p  --p  --p
        //1 -> 2 -> 3 -> 4
        //p1	last p2
        ListNode newHead = null;
        ListNode p = head, p1 = null, p2 = null, last = null;
        while (p != null && p.next != null) {
            if (newHead == null) {
                newHead = p.next;
            }
            p1 = p;
            p = p.next;
            p2 = p.next;
            p.next = p1;
            p.next.next = p2;
            if (last != null) {
                last.next = p;
            }
            last = p.next;
            p = p.next.next;
        }
        return newHead;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
