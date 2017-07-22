package com.budongbai.offer;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Node node = cloneNodes(head);
        node = collectRandomNode(node);
        node = splitNode(node);
        return node;

    }

    private Node cloneNodes(Node head) {
        Node cur = head;
        while (cur != null) {
            Node clonedNode = new Node(cur.val);

            clonedNode.next = cur.next;
            cur.next = clonedNode;

            cur = clonedNode.next;
        }
        return head;
    }

    private Node collectRandomNode(Node head) {
        Node cur = head;

        while (cur != null) {
            Node clonedNode = cur.next;

            if (cur.random != null) {
                clonedNode.random = cur.random.next;
            }
            cur = clonedNode.next;
        }
        return head;
    }

    private Node splitNode(Node head) {
        Node cur = head;
        Node clonedHead = null, clonedNode = null;

        while (cur != null) {
            if (cur.next != null) {
                if (clonedHead == null) {
                    clonedHead = cur.next;
                    clonedNode = cur.next;
                } else {
                    clonedNode.next = cur.next;
                    clonedNode = clonedNode.next;
                }
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }

        return clonedHead;
    }
}
