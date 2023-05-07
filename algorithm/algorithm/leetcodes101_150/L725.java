package algorithm.leetcodes101_150;

import algorithm.helpers.ListNode;

public class L725 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        int num = count / k;
        int remaining = count % k;

        ListNode[] array = new ListNode[k];

        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            array[i] = cur;
            int size = num + (i < remaining ? 1 : 0);
            while (size > 1) {
                cur = cur.next;
                size--;
            }

            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return array;
    }
}
