package algorithm.leetcodes101_150;

import java.util.Arrays;
import java.util.Random;

public class M1714 {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0 || arr == null || arr.length == 0) {
            return new int[0];
        }

        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            heapify(arr, i, len);
        }

        for (int i = len; i > len - k; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
        System.out.println(Arrays.toString(arr));
        int[] res = new int[k];
        System.arraycopy(arr, len - k + 1, res, 0, k);
        return res;
    }

    private void heapify(int[] arr, int index, int len) {
        int li = (index << 1) + 1;
        int ri = li + 1;

        if (li > len) {
            return;
        }
        int cMin = li;
        if (ri <= len && arr[ri] < arr[li]) {
            cMin = ri;
        }

        if (arr[cMin] < arr[index]) {
            swap(arr, cMin, index);
            heapify(arr, cMin, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private void quickSort2(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }

        int i = l, j = r;
        int ridx = new Random().nextInt(r - l + 1) + l;
        swap(arr, ridx, l);
        int p = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= p) {
                j--;
            }
            while (i < j && arr[i] <= p) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);

        if (i > k) {
            quickSort2(arr, l, i - 1, k);
        }
        if (i < k) {
            quickSort2(arr, i + 1, r, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 1, 0};
        new M1714().quickSort2(arr, 0, arr.length - 1, 4);
        System.out.println(Arrays.toString(arr));
    }
}
