package datastructures;

import java.util.Arrays;
import java.util.Random;

public class SmallestK {
    int k;

    public int[] smallestK(int[] arr, int _k) {
        k = _k;
        int n = arr.length;
        int[] ans = new int[k];
        if (k == 0) return ans;
        qsort(arr, 0, n - 1);
        System.arraycopy(arr, 0, ans, 0, k);
        return ans;
    }

    void qsort(int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int ridx = new Random().nextInt(r - l + 1) + l;
        swap(arr, ridx, l);
        int x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) j--;
            while (i < j && arr[i] <= x) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 集中答疑：因为题解是使用「基准点左侧」来进行描述（不包含基准点的意思），所以这里用的 k（写成 k - 1 也可以滴
        if (i > k) qsort(arr, l, i - 1);
        if (i < k) qsort(arr, i + 1, r);
    }

    void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 8, 9, 1, 0};
        new SmallestK().smallestK(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
