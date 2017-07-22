package datastructures.trees;

/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年6月11日 下午8:35:23
 * 类说明：
 */
public class BSTreeTest {

    public static void main(String[] args) {
        double x = 3.0;
        int y = 5;
        x /= --y;
        System.out.println(x);

        BSTree<Integer> test = new BSTree<Integer>();
		/*test.insert(7);
		test.insert(6);
		test.insert(4);
		test.insert(5);
		test.insert(13);
		test.insert(10);
		test.insert(8);
		test.insert(12);
		test.insert(9);
		test.insert(11);*/
        test.insert(7);
        test.insert(3);

        test.insert(4);
        test.insert(5);
        test.insert(6);


        test.insert(8);
        test.insert(9);
        test.insert(10);
        test.insert(11);
        test.insert(12);
        System.out.println("高度：" + test.maxDepth() + ", " + test.maxDepthWithLevelTraversal(test));

        System.out.println("前序：");
        test.preOrder();
        System.out.println("\n中序：");
        test.inOrder();
        System.out.println("\n后序：");
        test.postOrder();

        System.out.println("\n非递归前序：");
        test.preOrder2();
        System.out.println("\n非递归中序：");
        test.inOrder2();
        System.out.println("\n非递归后序：");
        test.postOrder2();

        System.out.println("\n打印某层次的节点：");
        System.out.println("当前层节点数：" + test.printNodeAtLevel(test.getRoot(), 3));

        System.out.println("\n层次遍历：");
        test.levelOrderWithRecursion(6);
        System.out.println();
        test.levelOrderWithRecursion();
        System.out.println("\n非递归层次遍历:");
        test.levelOrder();
        System.out.println("\n非递归层次遍历:");
        test.levelOrder2();

        System.out.println();
        System.out.println(test.maxDepth());

        System.out.println();
        System.out.println(test.successor(test.search(6)));

        System.out.println();
        System.out.println(test.predecessor(test.search(10)));
    }

}
