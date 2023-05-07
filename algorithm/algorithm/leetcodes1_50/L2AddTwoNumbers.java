package algorithm.leetcodes1_50;

import algorithm.helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年6月14日下午3:56:18
 */

public class L2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tmp = 0;
        while (l1 != null || l2 != null || tmp != 0) {
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(tmp % 10);
            p = p.next;

            // 进位
            tmp = tmp / 10;
        }
        return head.next;
    }

    public static void main(String[] args) {


    }

}
