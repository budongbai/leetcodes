package leetcodes51_100;

import helpers.InitUtils;
import helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年8月3日下午10:37:43
 */
public class L86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0), n = newHead;
        ListNode fm = new ListNode(0), more = fm;
        while (head != null) {
            if (head.val < x) {
                n.next = head;
                n = n.next;
            } else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        more.next = null;
        n.next = fm.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 2, 5, 1};
        ListNode head = InitUtils.initList(nums);
        L86 test = new L86();
        ListNode p = test.partition(head, 3);
        System.out.println("p=" + InitUtils.toString(p));
    }
}
