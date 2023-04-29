package algorithm.offer.binarytree;

import java.util.Arrays;

public class VerifyPostOrder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 0) {
            return true;
        }
        int length = postorder.length;
        // 后序遍历的最后一个节点是根节点
        int root = postorder[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (postorder[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < length - 1; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            left = verifyPostorder(Arrays.copyOfRange(postorder, 0, i));
        }

        boolean right = true;
        if (i < length - 1) {
            right = verifyPostorder(Arrays.copyOfRange(postorder, i, length - 1));
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] array = {4, 8, 6, 12, 16, 14, 10};
        boolean result = new VerifyPostOrder().verifyPostorder(array);
        System.out.println(result);
    }
}
