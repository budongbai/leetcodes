package algorithm.offer.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {


    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left != null) {
            queue.offer(root.left);
        }
        if (root.right != null) {
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            list.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(root.val));
        int level = 1;
        if (root.left != null) {
            queue.offer(root.left);
            levelQueue.offer(level);
        }
        if (root.right != null) {
            queue.offer(root.right);
            levelQueue.offer(level);
        }
        while (!queue.isEmpty() && !levelQueue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentLevel = levelQueue.poll();
            if (currentLevel == list.size()) {
                list.add(new ArrayList<>());
            }
            list.get(currentLevel).add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
                levelQueue.offer(currentLevel + 1);
            }
            if (current.right != null) {
                queue.offer(current.right);
                levelQueue.offer(currentLevel + 1);
            }
        }

        return list;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(root.val));
        if (root.left != null) {
            stack1.add(root.left);
        }
        if (root.right != null) {
            stack1.add(root.right);
        }

        boolean flag = true;
        int index = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<TreeNode> popStack = null, pushStack = null;
            if (flag) {
                popStack = stack1;
                pushStack = stack2;
            } else {
                popStack = stack2;
                pushStack = stack1;
            }
            TreeNode current = popStack.pop();

            if (index == list.size()) {
                list.add(new ArrayList<>());
            }
            list.get(index).add(current.val);
            if (!flag) {
                if (current.left != null) {
                    pushStack.add(current.left);
                }
                if (current.right != null) {
                    pushStack.add(current.right);
                }
            } else {
                if (current.right != null) {
                    pushStack.add(current.right);
                }
                if (current.left != null) {
                    pushStack.add(current.left);
                }
            }


            if (popStack.isEmpty()) {
                flag = !flag;
                index++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;

        node2.right = node4;

        new LevelOrder().levelOrder3(root);
    }
}
