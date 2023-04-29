

package algorithm.num1;

public class ListReverse {

    public static ListNode reverseRecursion(ListNode head) {
        // base case: 邻接点为空，结束递归
        if (head.next == null) {
            return head;
        }
        // 递归head.next
        ListNode last = reverseRecursion(head.next);
        // head null
        // |    |
        // 1 -> 2 <- 3

        //        head
        //         |
        // null <- 1 <- 2 <- 3
        //
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null, cur = head, next;

        while(cur != null){
            // next记录当前节点的下一个节点
            next = cur.next;
            // 反转赋值
            cur.next = prev;
            // prev cur两指针向前挪
            prev = cur;
            cur = next;
        }

        return prev;
    }



    public static ListNode reverse(ListNode head, ListNode b){
        ListNode prev = null, cur = head, next;

        while(cur != b){
            // next记录当前节点的下一个节点
            next = cur.next;
            // 反转赋值
            cur.next = prev;
            // prev cur两指针向前挪
            prev = cur;
            cur = next;
        }

        return prev;
    }
    public static ListNode successor = null;

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;

    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode cur = null;
        for (int i = 1; i <= 5; i++) {
            ListNode node = new ListNode(i);
            if (cur != null) {
                cur.next = node;
            }
            cur = node;

            if (i == 1) {
                head = node;
            }

        }

        ListNode temp = reverse(head);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }
}
