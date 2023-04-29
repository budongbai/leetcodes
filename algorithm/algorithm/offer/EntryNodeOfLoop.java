package algorithm.offer;

import algorithm.num1.ListNode;

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        // 先找链表中有没有环
        ListNode meetingNode = meetingNode(pHead);
        // 没有环，也就不可能有入口节点
        if (meetingNode == null) {
            return null;
        }
        // 有环，计算一下环的长度
        int lengthOfLoop = 1;
        ListNode p1 = meetingNode;
        while (p1.next != meetingNode) {
            p1 = p1.next;
            lengthOfLoop++;
        }
        p1 = pHead;
        // 从头节点开始，直到指向第lengthOfLoop个节点
        for (int i = 0; i < lengthOfLoop; i++) {
            p1 = p1.next;
        }

        ListNode p2 = pHead;

        // p2再从头节点和p1一起走，走到他俩相同时，即入口节点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        return null;
    }
}