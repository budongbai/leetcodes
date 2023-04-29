package algorithm.offer;

import algorithm.offer.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 存路径
        Deque<Integer> deque = new ArrayDeque<>();

        // 存可能的输出结果
        List<List<Integer>> list = new ArrayList<>();

        // 递归调用
        findPath(root, target, deque, 0, list);


        return list;
    }

    private void findPath(TreeNode root, int target, Deque<Integer> deque, int currentSum, List<List<Integer>> list) {
        // 路径和
        currentSum += root.val;

        // 加到路径里
        deque.addLast(root.val);

        boolean isLeaf = root.left == null && root.right == null;

        // 如果当前路径和等于目标值，则把路径加到输出结果中，再继续遍历其左右节点
        if (currentSum == target && isLeaf) {

            List<Integer> pathList = new ArrayList<>(deque);
            list.add(pathList);
        }

        // 遍历左节点
        if (root.left != null) {
            findPath(root.left, target, deque, currentSum, list);
        }

        // 遍历右节点
        if (root.right != null) {
            findPath(root.right, target, deque, currentSum, list);
        }
        // 当前节点遍历完了，就要把节点弹出
        deque.removeLast();
    }
}
