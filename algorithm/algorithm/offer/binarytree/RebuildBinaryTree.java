package algorithm.offer.binarytree;

import java.util.Arrays;

public class RebuildBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            // 找到中序中root节点当前index，用index切分数组
            // pre 0 root [1, i+1) 左子树 [i+1, length) 右子树
            // in [0, i) 左子树 i root [i+1, length)
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(
                    Arrays.copyOfRange(pre, 1, i + 1),
                    Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(
                    Arrays.copyOfRange(pre, i + 1, pre.length),
                    Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4};
        int[] in = {4, 3, 2, 1};

        TreeNode root = reConstructBinaryTree(pre, in);

        System.out.println(root);
    }
}
