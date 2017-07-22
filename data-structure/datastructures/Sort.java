package datastructures;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年3月22日下午8:37:28
 */
public class Sort {
    /**
     * 冒泡排序
     *
     * @param array
     * @author budongbai
     * @version 2017年3月22日下午8:57:17
     */
    public static void bubble(int[] array) {
        int[] a = array.clone();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 插入排序
     *
     * @param array
     * @author budongbai
     * @version 2017年3月22日下午9:55:41
     */
    public static void insert(int[] array) {
        int[] a = array.clone();
        int temp, i, j;
        // 有序|i|无序
        // 有序i有序|i+1|无序
        for (i = 1; i < a.length; i++) {
            temp = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序（不稳定）
     *
     * @param array
     * @author budongbai
     * @version 2017年3月22日下午9:55:36
     */
    public static void selection(int[] array) {
        int[] a = array.clone();
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void quickSortRecursive(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int p = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            //找一个大于基准的
            while (arr[left] <= p && left < right)
                left++;
            //找一个小于基准的
            while (arr[right] >= p && left < right)
                right--;
            swap(arr, left, right);
        }
        //如果left位置的元素大于基准，就跟基准交换
        if (arr[left] > p)
            swap(arr, left, end);
        else
            left++;
        //System.out.println(Arrays.toString(arr));
        quickSortRecursive(arr, start, left - 1);
        quickSortRecursive(arr, left + 1, end);
    }

    /**
     * 快速排序，选一个基准，每次递归都找到这个基准所在的最后位置
     *
     * @param a
     * @author budongbai
     * @version 2017年4月14日下午4:40:22
     */
    public static void quick(int[] a) {
        int[] arr = a.clone();
        quickSortRecursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 希尔排序
     *
     * @author budongbai
     * @version 2017年4月14日下午9:36:24
     */
    public static void shell(int[] array) {
        int[] a = array.clone();

        int gap = 1, i, j, len = a.length;
        int temp;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }

        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = a[i];
                for (j = i - gap; j >= 0 && a[j] > temp; j -= gap) {
                    a[j + gap] = a[j];
                }
                a[j + gap] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a) {

        System.out.println("开始排序");
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        // 二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {

        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1])
                tmp[tIndex++] = a[left++];
            else
                tmp[tIndex++] = a[r1++];
        }
        // 将左边剩余的归并
        while (left <= mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while (r1 <= right) {
            tmp[tIndex++] = a[r1++];
        }

        // System.out.println("第"+(++number)+"趟排序:\t");

        // 从临时数组拷贝到原数组
        while (cIndex <= right) {
            a[cIndex] = tmp[cIndex];
            // 输出中间归并排序结果
            //System.out.print(a[cIndex] + "\t");
            cIndex++;
        }
        //System.out.println();
    }

    public static void main(String[] args) {


        int[] array = {45, 6, 34, 5, 7, 12, 65, 23, 4};
        Arrays.sort(array);
        // bubble(array);
        // insert(array);
        // selection(array);
        quick(array);
        //shell(array);
        // Arrays.sort(array);
        //mergeSort(array);
    }

}
