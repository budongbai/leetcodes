package leetcodes51_100;

import helpers.InitUtils;
import helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年8月3日下午10:37:43
 */
public class L86 {
    // 遍历链表，小于x的放small，大于x的放large，最后拼接两个链表
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = new ListNode(0), small = smallHead;
        ListNode largeHead = new ListNode(0), large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 2, 5, 1};
        ListNode head = InitUtils.initList(nums);
        L86 test = new L86();
        ListNode p = test.partition(head, 3);
        System.out.println("p=" + InitUtils.toString(p));
    }
}
