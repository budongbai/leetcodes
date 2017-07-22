package leetcodes101_150;

import com.budongbai.offer.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;

        indexMap = new HashMap<>(n << 1);

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        // 根节点 = preLeft
        // 找到中序遍历中根节点的下标
        int inRoot = indexMap.get(preorder[preLeft]);

        TreeNode root = new TreeNode(preorder[preLeft]);

        int size = inRoot - inLeft;

        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + size, inLeft, inRoot - 1);
        root.right = buildTree(preorder, inorder, preLeft + size + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4};
        int[] in = {4, 3, 2, 1};

        TreeNode root = new L105().buildTree(pre, in);

        System.out.println(root);
    }

}
