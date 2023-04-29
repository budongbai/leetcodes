package algorithm.leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月14日下午4:56:15
 */
public class L4两有序数组的中间值 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            return (findKth(nums1, nums2, (m + n) / 2) + findKth(nums1, nums2, (m + n) / 2 - 1)) / 2;
        } else {
            return findKth(nums1, nums2, (m + n) / 2);
        }
    }

    public double findKth(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        double kth = 0;
        while (i < nums1.length && j < nums2.length && k >= 0) {
            kth = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            k--;
        }
        while (i < nums1.length && k >= 0) {
            kth = nums1[i++];
            k--;
        }
        while (j < nums2.length && k >= 0) {
            kth = nums2[j++];
            k--;
        }
        return kth;
    }

    public static void main(String[] args) {
        int[] nums1 = {416, 456, 567, 588};
        int[] nums2 = {878, 888, 989, 1023, 3456};
        System.out.println(new L4两有序数组的中间值().findMedianSortedArrays(nums1, nums2));
        int[] nums3 = {416, 456, 567, 588};
        int[] nums4 = {878, 888, 989};
        System.out.println(new L4两有序数组的中间值().findMedianSortedArrays(nums3, nums4));
    }
}
