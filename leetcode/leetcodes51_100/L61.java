package leetcodes51_100;

import helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年7月14日下午12:50:37
 */
public class L61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode p1 = p;
        ListNode p2 = p;
        int i = 0;
        int n = 0;
        while (i < k) {
            if (p1.next == null) {
                n = i + 1;
                k %= n;
                p1 = p;
                i = 0;
            } else {
                p1 = p1.next;
                i++;
            }
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p;
        ListNode newHead = p2.next;
        p2.next = null;

        return newHead;
    }

    public ListNode rotateRight3(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        L61 test = new L61();
        ListNode res = test.rotateRight(head, 4);
        ListNode p = res;
        System.out.println(p.val);
        while (p.next != null) {

            p = p.next;
            System.out.println(p.val);
        }
        //System.out.println(res.val);
    }
}
