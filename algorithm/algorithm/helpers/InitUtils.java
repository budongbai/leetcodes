package algorithm.helpers;

/**
 * @author budongbai
 * @version 2017年8月3日下午10:59:24
 */
public class InitUtils {
    public static ListNode initList(int[] nums) {
        ListNode head = new ListNode(0), p = head;

        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head.next;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            sb.append(p.val + "->");
            p = p.next;
        }
        return sb.toString();
    }

}
