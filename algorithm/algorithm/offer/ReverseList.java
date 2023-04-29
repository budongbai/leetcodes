package algorithm.offer;

import algorithm.num1.ListNode;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverseHead = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {

            ListNode next = cur.next;

            if (next == null) {
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return reverseHead;
    }

    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = ReverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        head.next = p2;
        p2.next = p3;


        new ReverseList().ReverseList2(head);
    }


}
