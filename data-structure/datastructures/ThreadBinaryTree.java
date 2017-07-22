package datastructures;

/**
 * @author budongbai
 * @version 2017年5月10日下午7:28:35
 */
public class ThreadBinaryTree<T extends Comparable<T>> {

    private TBTNode<T> pre; // 线索化时访问的上一个节点

    public TBTNode<T> createBinaryTree(T[] array, int index) {
        TBTNode<T> node = null;

        if (index < array.length) {
            node = new TBTNode<T>(array[index]);
            node.left = createBinaryTree(array, index * 2 + 1);
            node.right = createBinaryTree(array, index * 2 + 2);
        }
        return node;
    }

    /**
     * 中序线索化
     *
     * @param tree
     * @author budongbai
     * @version 2017年5月10日下午8:48:33
     */
    public void inThreadOrder(TBTNode<T> tree) {
        if (tree == null) {
            return;
        }
        inThreadOrder(tree.left);
        //处理左前驱
        if (tree.left == null) {
            tree.lTag = true;
            tree.left = pre;
        }
        // 前一个节点的后继节点指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = tree;
            pre.rTag = true;
        }
        pre = tree;
        inThreadOrder(tree.right);
    }

    /**
     * 中序后继遍历
     *
     * @param node
     * @author budongbai
     * @version 2017年5月10日下午8:48:15
     */
    public void inThreadList(TBTNode<T> node) {
        // 找到中序遍历方式开始的节点
        while (node != null && !node.lTag) {
            node = node.left;
        }
        while (node != null) {
            System.out.print(node.key + ", ");
            // 如果右指针是线索
            if (node.rTag) {
                node = node.right;
            } else { // 如果右指针不是线索，找到右子树开始的节点
                node = node.right;
                while (node != null && !node.lTag) {
                    node = node.left;
                }
            }
        }
    }

    /**
     * 中序前驱遍历
     *
     * @param node
     * @author budongbai
     * @version 2017年5月10日下午8:48:45
     */
    public void inPreThreadList(TBTNode<T> node) {
        // 找到中序遍历的最后一个节点
        while (node.right != null && !node.rTag) {
            node = node.right;
        }

        while (node != null) {
            System.out.print(node.key + ", ");

            // 如果左指针是线索
            if (node.lTag) {
                node = node.left;

            } else { // 如果左指针不是线索，找到左子树开始的节点
                node = node.left;
                while (node.right != null && !node.rTag) {
                    node = node.right;
                }
            }
        }
    }

    /**
     * 前序线索化
     *
     * @param node
     * @author budongbai
     * @version 2017年5月10日下午8:49:09
     */
    public void preThreadOrder(TBTNode<T> node) {
        if (node == null) {
            return;
        }
        // 左指针为空,将左指针指向前驱节点
        if (node.left == null) {
            node.left = pre;
            node.lTag = true;
        }
        // 前一个节点的后继节点指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rTag = true;
        }
        pre = node;
        // 处理左子树
        if (!node.lTag) {
            preThreadOrder(node.left);
        }
        // 处理右子树
        if (!node.rTag) {
            preThreadOrder(node.right);
        }
    }

    /**
     * 前序遍历线索二叉树（按照后继线索遍历）
     *
     * @param node
     */
    public void preThreadList(TBTNode<T> node) {
        while (node != null) {
            while (!node.lTag) {
                System.out.print(node.key + ", ");
                node = node.left;
            }
            System.out.print(node.key + ", ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};

        ThreadBinaryTree<String> tree = new ThreadBinaryTree<String>();
        TBTNode<String> root = tree.createBinaryTree(array, 0);

        tree.inThreadOrder(root);
        System.out.println("中序按后继节点遍历线索二叉树结果：");
        tree.inThreadList(root);
        System.out.println("\n中序按前驱节点遍历线索二叉树结果：");
        tree.inPreThreadList(root);

        ThreadBinaryTree<String> tree2 = new ThreadBinaryTree<String>();
        TBTNode<String> root2 = tree2.createBinaryTree(array, 0);
        tree2.preThreadOrder(root2);
        tree2.pre = null;
        System.out.println("\n前序按后继节点遍历线索二叉树结果：");
        tree.preThreadList(root2);
    }
}
