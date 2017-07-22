

package com.budongbai.leetcode.algorithm.list;

import com.budongbai.leetcode.algorithm.num1.ListNode;

public class No21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null, tmp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (tmp == null) {
                    tmp = l1;
                } else {
                    tmp.next = l1;
                    tmp = tmp.next;
                }
                if (newHead == null) {
                    newHead = tmp;
                }
                l1 = l1.next;
            } else {
                if (tmp == null) {
                    tmp = l1;
                } else {
                    tmp.next = l2;
                    tmp = tmp.next;
                }
                if (newHead == null) {
                    newHead = tmp;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            if (tmp != null) {
                tmp.next = l1;
            } else {
                newHead = l1;
            }

        }
        if (l2 != null) {
            if (tmp != null) {
                tmp.next = l2;
            } else {
                newHead = l2;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode newHead = mergeTwoLists(l1, l2);
        ListNode tmp = newHead;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }
}
