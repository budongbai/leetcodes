

package com.budongbai.leetcode.algorithm.list;

import com.budongbai.leetcode.algorithm.num1.ListNode;

public class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode b = head;

        for (int i = 0; i < k; i++) {
            // base case: 不足k个，直接返回，不进行反转
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        // 反转前 k 个元素
        ListNode newHead = reverse(head, b);
        // 前面的[head, b = head+k) 反转完成，下一个区间[b, b+k)
        head.next = reverseKGroup(b, k);

        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null, cur = a, next;

        while (cur != b) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }
}
