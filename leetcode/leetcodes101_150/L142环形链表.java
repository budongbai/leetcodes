package leetcodes101_150;

import helpers.ListNode;

public class L142环形链表 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 找到链表中快慢指针的第一个相遇点，假设相遇点与环的第一个节点距离为m。整个环的长度为k。
        // 到第一个相遇点时，快慢指针共走了n步。
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 无环
        if (fast == null || fast.next == null) {
            return null;
        }
        // 慢指针从头开始
        slow = head;
        // 快慢一起走，直到相遇，就是环的第一个入口节点。
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
