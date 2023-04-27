package com.budongbai.offer;

import com.budongbai.leetcode.algorithm.num1.ListNode;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null || k < 1) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
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
