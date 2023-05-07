package algorithm.leetcodes101_150;

import algorithm.helpers.ListNode;

import java.util.HashSet;
import java.util.Set;

public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p1 = headA;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
            set.add(p1);
        }
        ListNode p2 = headB;
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }

    /**
     * 一个指针遍历a链，遍历到头，再遍历b链；另一个指针遍历b链，遍历到头，再遍历a链。这样如果a链b链是相交的，最后肯定会相同节点。如果不相交，就是到末尾。
     *
     * @param headA ListNode
     * @param headB ListNode
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }
        return p1;
    }

}
