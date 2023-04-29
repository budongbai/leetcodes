package algorithm.leetcodes101_150;

import helpers.ListNode;

public class L206 {
    // 定义：输入一个单链表头结点，将该链表反转，返回新的头结点
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // head : 1
        // (2 -> 3 -> 4 -> 5 -> null)  reverse(head.next)
        // head.next.next = head;  -> 将 1 的 next (2) 的 next 指向1
        // 1 <- 2  3 -> 4 -> 5 -> null
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

}
