package algorithm.list;

import helpers.ListNode;

import java.util.List;

/**
 * 反转链表 - 递归
 */
public class ReverseList {
    /**
     * https://leetcode.cn/problems/reverse-linked-list/
     */
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

    ListNode reverse2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            // 反转节点
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nxt;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }


    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // 反转后
        // 1 <- 2 <- 3    4 -> 5 -> null
        // 1 -> 4
        // head -> successor
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

    /**
     * https://leetcode.cn/problems/reverse-linked-list-ii/
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 迭代做法
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 先找到待反转节点的pre节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        // 在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    /**
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            // 不足k个，不需要反转
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转 [a,b)
        ListNode newHead = reverse(a, b);

        // 反转 [b, null)
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
