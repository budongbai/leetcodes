package algorithm.tree;

import algorithm.offer.binarytree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTree {

    // 记录最大直径的长度
    int maxDiameter = 0;

    /**
     * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">543. 二叉树的直径</a>
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }

    /**
     * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a>
     */
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /* 后序遍历位置 */
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


    /**
     * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
     */
    public Node connect(Node root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }

    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. 从前序与中序遍历序列构造二叉树</a>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            // 找到中序中root节点当前index，用index切分数组
            // pre 0 root [1, i+1) 左子树 [i+1, length) 右子树
            // in [0, i) 左子树 i root [i+1, length) 右子树
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(
                        Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));

                root.right = buildTree(
                        Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }

    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
     */
    public TreeNode buildTreeFromInPost(int[] inorder, int[] postorder) {

        if (postorder.length == 0 && inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            // 找到中序中root节点当前index，用index切分数组
            // post length-1 root [0, i) 左子树 [i, length-1) 右子树
            // in [0, i) 左子树 i root [i+1, length) 右子树
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.left = buildTree(
                        Arrays.copyOfRange(inorder, 0, i),
                        Arrays.copyOfRange(postorder, 0, i));

                root.right = buildTree(
                        Arrays.copyOfRange(inorder, i + 1, inorder.length),
                        Arrays.copyOfRange(postorder, i, postorder.length - 1));
            }
        }
        return root;
    }


    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;

        indexMap = new HashMap<>(n << 1);

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree2(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    private TreeNode buildTree2(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        // 根节点 = preLeft
        // 找到中序遍历中根节点的下标
        int inRoot = indexMap.get(preorder[preLeft]);

        TreeNode root = new TreeNode(preorder[preLeft]);

        int size = inRoot - inLeft;

        root.left = buildTree2(preorder, inorder, preLeft + 1, preLeft + size, inLeft, inRoot - 1);
        root.right = buildTree2(preorder, inorder, preLeft + size + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    /**
     * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
     * <p></p>
     * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
     * <p>
     * 创建一个根节点，其值为 nums 中的最大值。
     * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
     * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
     * 返回 nums 构建的 最大二叉树 。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        // 根节点总是最大值，以根节点划分左右子树即可。
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int best = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > nums[best]) {
                best = i;
            }
        }
        TreeNode root = new TreeNode(nums[best]);
        root.left = constructMaximumBinaryTree(nums, left, best - 1);
        root.right = constructMaximumBinaryTree(nums, best + 1, right);
        return root;
    }

    /**
     * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/">889. 根据前序和后序遍历构造二叉树</a>
     * <p>
     * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
     * <p>
     * 如果存在多个答案，您可以返回其中 任何 一个。
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0 && postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1 ) {
            return root;
        }

        // 找到中序中root节点当前index，用index切分数组
        // post length-1 root [0, i) 左子树 [i, length-1) 右子树
        // pre pre 0 root [1, i+1) 左子树 [i+1, length) 右子树
        int left = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (postorder[i] == preorder[1]) {
                left = i + 1;
            }
        }

        root.left = constructFromPrePost(
                Arrays.copyOfRange(preorder, 1, left + 1),
                Arrays.copyOfRange(postorder, 0, left));

        root.right = constructFromPrePost(
                Arrays.copyOfRange(preorder, left + 1, preorder.length),
                Arrays.copyOfRange(postorder, left, postorder.length - 1));

        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
