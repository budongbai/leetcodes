package algorithm.leetcodes51_100;

import algorithm.helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年7月21日下午9:02:57
 */
public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode now = p;
            while (now.next != null && now.next.val == now.val) {
                now = now.next;
            }
            p.next = now.next;
            p = p.next;
        }
        return head;
    }
}
