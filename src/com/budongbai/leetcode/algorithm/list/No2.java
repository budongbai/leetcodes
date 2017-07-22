

package com.budongbai.leetcode.algorithm.list;

import com.budongbai.leetcode.algorithm.num1.ListNode;

public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode now = null;
        int jinwei = 0;
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + jinwei;
            if (head == null) {
                head = new ListNode(sum % 10);
                now = head;
            } else {
                now.next = new ListNode(sum % 10);
                now = now.next;
            }
            jinwei = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + jinwei;
            jinwei = sum / 10;

            now.next = new ListNode(sum % 10);
            now = now.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + jinwei;
            jinwei = sum / 10;
            now.next = new ListNode(sum % 10);
            now = now.next;
            l2 = l2.next;
        }
        if (jinwei != 0) {
            now.next = new ListNode(jinwei);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        No2 no2 = new No2();
        ListNode re = no2.addTwoNumbers(listNode1, listNode2);
        System.out.println(re);
    }
}
