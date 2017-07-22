package didi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月26日下午4:06:28
 */
public class Main2 {

    public static void sortK(int[] arr, int k) {
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;// 第一个非叶子节点
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }
        for (int i = len; i >= len - k; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void maxHeapify(int[] arr, int index, int len) {
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1; // 右子节点索引
        int cMax = li; // 子节点值最大索引，默认左子节点。

        if (li > len)
            return; // 左子节点索引超出计算范围，直接返回。
        if (ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if (arr[cMax] > arr[index]) {
            swap(arr, cMax, index); // 如果父节点被子节点调换，
            maxHeapify(arr, cMax, len); // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] ss = s.split("\\s+");
        int[] nums = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
        }

        int k = scan.nextInt();
        sortK(nums, k);
        System.out.println(nums[nums.length - k]);
        scan.close();

    }

}
