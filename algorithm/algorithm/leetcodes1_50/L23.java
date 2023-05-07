package algorithm.leetcodes1_50;

import algorithm.helpers.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author budongbai
 * @version 2017年7月4日下午7:46:35
 */
public class L23 {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[5];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ListNode((int) Math.random() * 10);
        }
        new L23().mergeKLists2(lists);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 两两merge
        if (lists == null || lists.length == 0)
            return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        //创建一个优先队列，这个优先队列是升序的，这个队列的长度是k。也就是说每次我都是放第k个数组中的一个到队列里。
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        //将所有的头结点放到优先队列
        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        //当队列不为空时，弹出结点。如果弹出结点有next结点，则将next结点放到队列中。
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        //二分排序法
        return partition(lists, 0, lists.length - 1);
    }

    public static ListNode partition(ListNode[] lists, int s, int e) {
        if (s == e)
            return lists[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partition(lists, s, q);
            ListNode l2 = partition(lists, q + 1, e);
            return mergeTwoLists(l1, l2);
        } else
            return null;
    }

}
