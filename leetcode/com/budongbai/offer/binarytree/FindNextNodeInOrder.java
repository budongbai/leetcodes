package com.budongbai.offer.binarytree;

public class FindNextNodeInOrder {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 节点有右子树，那右子树中的最左节点就是下一个节点
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;

            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 没有右子树，则找第一个当前节点是父节点左孩子的节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;

    }

    public static void main(String[] args) {

    }
}
