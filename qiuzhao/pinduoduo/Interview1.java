package pinduoduo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author budongbai
 * @version 2017年8月14日上午9:46:52
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode sibling;
}

public class Interview1 {
    public TreeNode addSibling(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
            if (queue.isEmpty())
                cur.sibling = null;
            else
                cur.sibling = queue.peek();
        }
        return root;
    }
}
