package com.budongbai.offer;


import com.budongbai.offer.binarytree.TreeNode;

public class Subtree {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }

        boolean result = false;
        // 如果根节点和b的根节点值相同，判定子结构是否相同
        if (a.val == b.val) {
            result = doesAHaveB(a, b);
        }
        // 树a的左子树作为根节点和b继续对比
        if (!result) {
            result = isSubStructure(a.left, b);
        }
        // 树a的右子树作为根节点和b继续对比
        if (!result) {
            result = isSubStructure(a.right, b);
        }
        return result;
    }

    private boolean doesAHaveB(TreeNode a, TreeNode b) {
        // 子树b节点为空，说明子树中的所有节点都对比完了，所以返回true
        if (b == null) {
            return true;
        }
        // 子树b还没完，但树a已经没有节点了，说明树a没有子树b
        if (a == null) {
            return false;
        }

        return a.val == b.val && doesAHaveB(a.left, b.left) && doesAHaveB(a.right, b.right);
    }
}
