package algorithm.list;

import helpers.ListNode;

/**
 * 回文链表
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        // 先找到中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow即中点
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        // 反转链表后半部分
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
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
}
