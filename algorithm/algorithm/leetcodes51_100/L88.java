package algorithm.leetcodes51_100;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月22日下午7:25:05
 */
public class L88 {
    //这种merge，还是要从后往前比较，这样移动的比较少
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1)
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while (j > -1)
            nums1[k--] = nums2[j--];
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int s = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[s] = nums1[i];
                i--;
            } else {
                nums1[s] = nums2[j];
                j--;
            }
            s--;
        }
        while (j >= 0) {
            nums1[s] = nums2[j];
            j--;
            s--;
        }
    }

    public static void main(String[] args) {
        L88 test = new L88();

        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 3;
        // nums1[3]= 8;
        int[] nums2 = {2, 5, 6};

        test.merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
