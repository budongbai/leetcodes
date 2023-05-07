package algorithm.leetcodes51_100;

import algorithm.helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年7月30日下午8:48:48
 */
public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode now = head;
        ListNode last = newHead;
        while (now != null) {
            //如果now的下一个节点值与当前节点值相等，则继续循环，直到找到不等的节点
            while (now.next != null && now.val == now.next.val) {
                now = now.next;
            }
            //如果当前节点不等于last的next节点，则说明前面遇到了相等的节点，则这时候last的next节点应该直接等于now的next节点
            if (now != last.next) {
                last.next = now.next;

            } else {
                last = last.next;
            }
            now = now.next;
        }
        return newHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;
        ListNode pre = FakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }
}
