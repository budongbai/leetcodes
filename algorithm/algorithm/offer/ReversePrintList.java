

package algorithm.offer;

import algorithm.helpers.ListNode;

import java.util.ArrayList;

public class ReversePrintList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = listNode;
        while (node != null) {
            list.add(0, node.val);
            node = node.next;
        }


        return list;
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(0, node.val);
            node = node.next;
        }

        int[] result = new int[list.size()];
        for(int i=0; i< list.size(); i++){
            result[i] = list.get(i);
        }

        return result;
    }

    static ArrayList<Integer> result = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            result.add(0, listNode.val);
            printListFromTailToHead2(listNode.next);
        }

        return result;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        printListFromTailToHead2(listNode1);

    }
}
