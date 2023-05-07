package algorithm.offer;

import algorithm.helpers.ListNode;

public class RemoveKNode {
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head0 = new ListNode(0);
        head0.next = head;
        ListNode slow = head0;
        ListNode fast = head0;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head0.next;
    }
}
