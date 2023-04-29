package algorithm.offer;

import algorithm.num1.ListNode;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null || k < 1) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        // 2个指针，一个先走 k-1 步，然后2个一起走，当先走的指针遇到null就是到链表末尾，另一个也就是到了第k个。
        for (int i = k; i > 1; i--) {
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                return null;
            }
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
