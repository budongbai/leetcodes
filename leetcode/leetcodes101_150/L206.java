package leetcodes101_150;

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
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
