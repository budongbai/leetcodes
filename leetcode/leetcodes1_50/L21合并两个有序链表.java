package leetcodes1_50;

import helpers.ListNode;

/**
 * @author budongbai
 * @version 2017年6月29日下午9:12:23
 */
public class L21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res, node;
        if (l1.val <= l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        node = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            node.next = l1;

        }
        if (l2 != null) {
            node.next = l2;
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res;
        if (l1.val <= l2.val) {
            res = l1;
            res.next = mergeTwoLists2(l1.next, l2);
        } else {
            res = l2;
            res.next = mergeTwoLists2(l2.next, l1);
        }
        return res;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l2.next, l1);
            return l2;
        }
    }

    public ListNode mergeTwoLists4(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                list.next = list2;
                list2 = list2.next;
            } else {
                list.next = list1;
                list1 = list1.next;
            }
            list = list.next;
        }
        if (list1 != null) {
            list.next = list1;
        }
        if (list2 != null) {
            list.next = list2;
        }
        return dummy.next;
    }
}
