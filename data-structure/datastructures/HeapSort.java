package datastructures;

import java.util.ArrayList;

/**
 * @author budongbai
 * @version 2017年4月15日下午12:58:43
 */
public class HeapSort {

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sortMin(ArrayList<Integer> arr) {
        /*
         * 第一步：将数组堆化 beginIndex = 第一个非叶子节点。 从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.size() - 1;
        int beginIndex = (len - 1) >> 1;// 第一个非叶子节点
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }

        /*
         * 第二步：对堆化数据排序 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后重新整理被换到根节点的末尾元素，使其符合堆的特性。 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i - 1);
        }
    }

    private void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private void maxHeapify(ArrayList<Integer> arr, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1; // 右子节点索引
        int cMax = li; // 子节点值最大索引，默认左子节点。

        if (li > len)
            return; // 左子节点索引超出计算范围，直接返回。
        if (ri <= len && arr.get(ri) > arr.get(li)) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if (arr.get(cMax) > arr.get(index)) {
            swap(arr, cMax, index); // 如果父节点被子节点调换，
            maxHeapify(arr, cMax, len); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sortMax(ArrayList<Integer> arr) {
        /*
         * 第一步：将数组堆化 beginIndex = 第一个非叶子节点。 从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         * 叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.size() - 1;
        int beginIndex = (len - 1) >> 1;// 第一个非叶子节点
        for (int i = beginIndex; i >= 0; i--) {
            minHeapify(arr, i, len);
        }

        /*
         * 第二步：对堆化数据排序 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。 直至未排序的堆长度为 0。
         */
        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            minHeapify(arr, 0, i - 1);
        }
    }

    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     *
     * @param index 需要堆化处理的数据的索引
     * @param len   未排序的堆（数组）的长度
     */
    private void minHeapify(ArrayList<Integer> arr, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1; // 右子节点索引
        int cMin = li; // 子节点值最小索引，默认左子节点。

        if (li > len)
            return; // 左子节点索引超出计算范围，直接返回。
        if (ri <= len && arr.get(ri) < arr.get(li)) // 先判断左右子节点，哪个较小。
            cMin = ri;
        if (arr.get(cMin) < arr.get(index)) {
            swap(arr, cMin, index); // 如果父节点被子节点调换，
            minHeapify(arr, cMin, len); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    public void insert(ArrayList<Integer> arr, int n, int num) {
        int i = arr.size();
        arr.add(num);// num插入堆尾
        while (i >= 0) {
            if (arr.get(i) > num) {
                arr.set(i + 1, arr.get(i));
                arr.set(i, num);
            }
            i--;
        }
    }

    /**
     * 测试用例
     * <p>
     * 输出： [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7,
     * 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        HeapSort test = new HeapSort();
        int[] arr = new int[]{16, 7, 3, 20, 17, 8};

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        //test.sortMax(list);
        System.out.println(list);
        test.sortMin(list);
        System.out.println(list);
        test.insert(list, list.size(), 2);
        System.out.println(list);
    }

}
