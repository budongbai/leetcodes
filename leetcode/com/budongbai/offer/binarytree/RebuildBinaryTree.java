package com.budongbai.offer.binarytree;

import java.util.Arrays;

public class RebuildBinaryTree {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
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
