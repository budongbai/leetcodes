

package algorithm.list;

import algorithm.num1.ListNode;

public class No92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode revert = null;
        ListNode cur = head;

        ListNode nodeM = null;
        ListNode nodeN = null;
        int i = 1;

        while (cur != null && i <= n) {
            if (i == m - 1) {
                // 找到m的前一个节点
                nodeM = cur;
            }

            if (i == m) {
                // 新建一个节点
                revert = new ListNode(cur.val);
                nodeN = revert;
            }

            if (i > m) {
                ListNode temp = new ListNode(cur.val);
                temp.next = revert;

                revert = temp;
            }
            cur = cur.next;
            i++;
        }
        if (nodeM != null) {
            nodeM.next = revert;
        } else {
            head = revert;
        }
        if (nodeN != null && cur != null) {
            nodeN.next = cur;
        }
        return head;
    }

    public ListNode reverse(ListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }


    public ListNode successor;

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 1; i <= 2; i++) {
            ListNode node = new ListNode(i);
            if (cur != null) {
                cur.next = node;
            }
            cur = node;

            if (i == 1) {
                head = node;
            }

        }

        ListNode reverse = reverseBetween(head, 1, 2);

        ListNode temp = reverse;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }


    }
}
