package datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author budongbai
 * @version 2017年5月10日上午10:00:00 包括了二叉树基本的操作，像先序遍历，中序遍历，后序遍历，层次遍历等等。
 * 还包括了中序线索二叉树的前驱和后继结点的计算。
 */
public class BSTree<T extends Comparable<T>> {

    private BSTNode<T> mRoot; // 根结点

    public BSTree() {
        mRoot = null;
    }

    public BSTNode<T> getRoot() {
        return mRoot;
    }

    private int maxDepth(BSTNode<T> tree) {
        return tree == null ? 0 : Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;
    }

    /**
     * 树的高度
     *
     * @return
     * @author budongbai
     * @version 2017年5月10日上午10:07:25
     */
    public int maxDepth() {
        return maxDepth(mRoot);
    }

    public int maxDepthWithLevelTraversal(BSTree<T> root) {
        /* 判断树是否为空 */
        if (root == null) {
            return 0;
        }
        int height = 0; // 初始化树的高度为0

        Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>(); // 初始化一个队列，并将根节点入队
        queue.offer(root.mRoot);

        /* 当队列不为空时 */
        /* 实际上当每次循环开始时，队列中存储的刚好是将要访问下一层的所有元素 */
        while (!queue.isEmpty()) {
            height++;
            int curLevelSize = queue.size(); // 记录当前层元素个数
            int cnt = 0;
            /* 弹出当前层所有元素 */
            while (cnt < curLevelSize) {
                BSTNode<T> temp = queue.poll();
                cnt++;
                /* 将下一层的元素入队列 */
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return height;
    }

    /*
     * 递归实现前序遍历"二叉树"
     */
    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /**
     * 非递归实现前序遍历
     *
     * @author budongbai
     * @version 2017年5月9日下午7:57:48
     */
    public void preOrder2() {
        // 利用栈的特性来实现非递归遍历
        Stack<BSTNode<T>> stack = new Stack<>();
        BSTNode<T> p = mRoot;
        // 只有在树不为空或者栈不为空时，才循环。两者都为空，则是遍历结束。
        while (p != null || !stack.empty()) {
            // 如果树不为空，则压栈
            while (p != null) {
                // 前序遍历，先输出父结点
                System.out.print(p.key + " ");
                // 压入栈
                stack.push(p);
                // 接着遍历左孩子
                p = p.left;
            }
            // 如果栈不为空，则开始取栈顶元素，之后弹栈，并遍历右孩子
            if (!stack.empty()) {
                // System.out.println(stack);
                p = stack.pop();
                p = p.right;
            }
        }
    }

    /*
     * 递归实现中序遍历"二叉树"
     */
    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /**
     * 非递归实现中序遍历
     *
     * @author budongbai
     * @version 2017年5月9日下午7:57:48
     */
    public void inOrder2() {
        Stack<BSTNode<T>> stack = new Stack<>();
        BSTNode<T> p = mRoot;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.pop();
                System.out.print(p.key + " ");
                p = p.right;
            }
        }
    }

    /*
     * 递归实现后序遍历"二叉树"
     */
    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /**
     * 非递归实现后序遍历
     *
     * @author budongbai
     * @version 2017年5月9日下午9:40:05
     */
    public void postOrder2() {
        Stack<BSTNode<T>> stack = new Stack<>();
        BSTNode<T> cur;
        BSTNode<T> pre = null;
        stack.push(mRoot);
        while (!stack.empty()) {
            cur = stack.peek();
            // 当左孩子和右孩子都为空，或者上一个访问的节点是当前节点的左孩子或右孩子，那么就可以直接访问当前节点了
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.key + " ");
                stack.pop();
                pre = cur;
            } else {
                // 先压入右孩子，再压入左孩子，因为栈是先进后出的，这样保证了弹栈时左孩子在右孩子之前。
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    /*
     * (递归实现)查找"二叉树x"中键值为key的节点
     */
    private BSTNode<T> search(BSTNode<T> x, T key) {
        if (x == null)
            return x;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
     * (非递归实现)查找"二叉树x"中键值为key的节点
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);

            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }
        return x;
    }

    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /*
     * 查找最小结点：返回tree为根结点的二叉树的最小结点。 最小结点肯定在左子树上，以tree为根节点时，它最左边的结点，就是最小结点。
     */
    private BSTNode<T> minimum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        BSTNode<T> p = minimum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * 查找最大结点：返回tree为根结点的二叉树的最大结点。最右边的结点，就是最大结点。
     */
    private BSTNode<T> maximum(BSTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        BSTNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
     */
    public BSTNode<T> successor(BSTNode<T> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null)
            return minimum(x.right);
        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        BSTNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /*
     * 找结点(x)的前驱结点。即，查找"二叉树中数据值小于该结点"的"最大结点"。
     */
    public BSTNode<T> predecessor(BSTNode<T> x) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (x.left != null)
            return maximum(x.left);
        // 如果x没有左孩子。则x有以下两种可能：
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        BSTNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /*
     * 将结点插入到二叉树中
     *
     * 参数说明： tree 二叉树的 z 插入的结点
     */
    private void insert(BSTree<T> bst, BSTNode<T> z) {
        int cmp;
        BSTNode<T> y = null;
        BSTNode<T> x = bst.mRoot;

        // 查找z的插入位置y
        while (x != null) {
            y = x;
            cmp = z.key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else
                x = x.right;
        }

        z.parent = y;
        // 如果y是null，也就表明这棵树为空，所以要插入的结点就作为根结点。
        if (y == null)
            bst.mRoot = z;
        else {
            cmp = z.key.compareTo(y.key);
            // 比z小，插入左子树，否则，插入右子树
            if (cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }

    /*
     * 新建结点(key)，并将其插入到二叉树中
     *
     * 参数说明： tree 二叉树的根结点 key 插入结点的键值
     */
    public void insert(T key) {
        BSTNode<T> z = new BSTNode<T>(key, null, null, null);

        // 如果新建结点失败，则返回。
        if (z != null)
            insert(this, z);
    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明： bst 二叉树 z 删除的结点
     */
    private BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> x = null;
        BSTNode<T> y = null;

        if ((z.left == null) || (z.right == null))
            y = z;
        else
            y = successor(z);

        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            bst.mRoot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != z)
            z.key = y.key;

        return y;
    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明： tree 二叉树的根结点 z 删除的结点
     */
    @SuppressWarnings("unused")
    public void remove(T key) {
        BSTNode<T> z, node;

        if ((z = search(mRoot, key)) != null)
            if ((node = remove(this, z)) != null)
                node = null;
    }

    /*
     * 销毁二叉树
     */
    private void destroy(BSTNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    /*
     * 打印"二叉查找树"
     *
     * key -- 节点的键值 direction -- 0，表示该节点是根节点; -1，表示该节点是它的父结点的左孩子;
     * 1，表示该节点是它的父结点的右孩子。
     */
    private void print(BSTNode<T> tree, T key, int direction) {

        if (tree != null) {

            if (direction == 0) // tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else
                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }

    /**
     * 递归实现打印某层次的节点，根节点为第0层。
     *
     * @param tree  根节点
     * @param level 层次
     * @return 失败返回0，否则返回节点个数
     * @author budongbai
     * @version 2017年5月10日上午9:45:35
     */
    public int printNodeAtLevel(BSTNode<T> tree, int level) {
        if (tree == null || level < 0) {
            return 0;
        }
        if (level == 0) {
            System.out.print(tree.key + " ");
            return 1;
        }
        return printNodeAtLevel(tree.left, level - 1) + printNodeAtLevel(tree.right, level - 1);
    }

    /**
     * 递归实现层次遍历
     *
     * @param depth 树的高度
     * @author budongbai
     * @version 2017年5月10日上午9:56:47
     */
    public void levelOrderWithRecursion(int depth) {
        for (int i = 0; i < depth; i++) {
            printNodeAtLevel(mRoot, i);
            System.out.println();
        }
    }

    /**
     * 递归实现层次遍历，不需要树的高度
     *
     * @author budongbai
     * @version 2017年5月10日上午9:56:47
     */
    public void levelOrderWithRecursion() {
        for (int i = 0; ; i++) {
            if (printNodeAtLevel(mRoot, i) == 0)
                break;
            System.out.println();
        }
    }

    /**
     * 整个过程其实就相当于原来链式存储转换成了顺序存储，与顺序存储的定义有所区别的是，这里得到的数组是连续的，中间没有空缺。就像是完全二叉树一样的结构，
     * 依次遍历就是层次遍历
     *
     * @param tree
     * @author budongbai
     * @version 2017年5月10日上午10:25:46
     */
    private void levelOrder(BSTNode<T> tree) {
        if (tree == null) {
            return;
        }
        ArrayList<BSTNode<T>> list = new ArrayList<BSTNode<T>>();// 使用了List的动态扩展
        list.add(tree);
        int cur = 0;
        int last = 1;
        // cur小于list.size()时，说明当前层尚未被访问。因此，依次访问cur到last直接的所有节点
        // 并依次将被访问节点的左右子节点压入list
        // cur==last，说明该层已被访问完，此时数组中还有未被访问到的节点，
        while (cur < list.size()) {
            last = list.size();// 记录了当前层最后一个节点的位置。
            while (cur < last) {
                // 当当前节点序号小于list中最后一个节点序号时，就输出当前的节点，并把左右节点插入到list中
                System.out.print(list.get(cur).key + " ");
                if (list.get(cur).left != null) {
                    list.add(list.get(cur).left);
                }
                if (list.get(cur).right != null) {
                    list.add(list.get(cur).right);
                }
                cur++;// 当前节点遍历完，沿list顺序后移。
            }
            System.out.println();
        }
    }

    private void levelOrder2(BSTNode<T> tree) {
        if (tree == null) {
            return;
        }
        Queue<BSTNode<T>> queue = new LinkedList<>();// 使用了List的动态扩展
        queue.offer(tree);
        while (!queue.isEmpty()) {
            BSTNode<T> p = queue.poll();
            System.out.print(p.key + " ");
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }

        }
    }

    public void levelOrder() {
        levelOrder(mRoot);
    }

    public void levelOrder2() {
        levelOrder2(mRoot);
    }
}