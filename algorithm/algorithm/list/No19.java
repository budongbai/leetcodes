

package algorithm.list;

import algorithm.helpers.ListNode;

import java.util.Stack;

public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        if (length == 1 && n == 1) {
            return null;
        }
        if (length == n) {
            return head.next;
        }
        tmp = head;
        int toDelete = length - n;
        while (tmp != null && toDelete > 1) {
            tmp = tmp.next;
            toDelete--;
        }
        if (tmp != null && tmp.next != null) {
            tmp.next = tmp.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        // 找到倒数第n个节点
        ListNode toDelete = null;
        for (int i = 0; i < n; i++) {
            toDelete = stack.pop();
        }
        if (stack.isEmpty() && toDelete != null) {
            return toDelete.next;
        }
        // 再弹一个节点，就是倒数第n+1个节点
        ListNode pre = stack.pop();
        if (toDelete != null) {
            pre.next = toDelete.next;
        }
        return head;
    }
}
