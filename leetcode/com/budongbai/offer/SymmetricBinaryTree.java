package com.budongbai.offer;

import com.budongbai.offer.binarytree.TreeNode;

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) {
            return false;
        }

        // 左节点和右节点比较
        return p1.val == p2.val && isSymmetric(p1.left, p2.right) && isSymmetric(p1.right, p2.left);
    }
}
