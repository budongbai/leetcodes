

package algorithm.num1;

public class No4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int max = (m + n) % 2 == 0 ? (m + n) / 2 - 1 : (m + n) / 2;
        while (k <= max && i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                j++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                i++;
                k++;
            } else {
                i++;
                j++;
                k += 2;
            }
        }

        while (k <= max && i < m) {
            i++;
            k++;
        }
        while (k <= max && j < n) {
            j++;
            k++;
        }
        if ((m + n) % 2 == 0) {
            if (i == m - 1) {
                return (nums2[j] + nums2[j + 1]) / 2.0;
            } else if (j == n - 1) {
                return (nums1[i] + nums2[i + 1]) / 2.0;
            } else {
                return (nums1[i] + nums2[j]) / 2.0;
            }
        } else {
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4};
        No4 no4 = new No4();
        no4.findMedianSortedArrays(arr1, arr2);
    }
}
