package com.budongbai.offer;

import com.budongbai.leetcode.algorithm.num1.ListNode;

public class DeleteDuplicateNode {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode pre = null;
        ListNode cur = pHead;

        while (cur != null) {
            ListNode next = cur.next;
            // 下一个节点和当前节点值相同，待删除
            boolean needDeleted = next != null && next.val == cur.val;
            if (needDeleted) {
                int value = cur.val;
                ListNode toDeleted = next;

                // 从当前节点向后遍历，直到next节点为null或值不同
                while (toDeleted != null && toDeleted.val == value) {
                    next = toDeleted.next;
                    toDeleted = next;
                }
                // 删除pre <-> next 之间的节点
                if (pre == null) {
                    pHead = next;
                } else {
                    pre.next = next;
                }
                cur = next;

            } else {
                pre = cur;
                cur = next;
            }
        }
        return pHead;
    }
}
