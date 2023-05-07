package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月7日下午4:59:11
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int l = 0, r = nums.length - 1; //二分范围
        while (l < r) {                  //查找元素的开始位置
            int mid = (l + r) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[r] != target) return new int[]{-1, -1}; //查找失败
        int L = r;
        l = 0;
        r = nums.length - 1;     //二分范围
        while (l < r) {                   //查找元素的结束位置

            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{L, r};
    }

    public int[] searchRange2(int[] A, int target) {
        int[] range = {A.length, -1};
        searchRange(A, target, 0, A.length - 1, range);
        if (range[0] > range[1]) range[0] = -1;
        return range;
    }

    public void searchRange(int[] A, int target, int left, int right, int[] range) {
        if (left > right) return;
        int mid = left + (right - left) / 2;
        if (A[mid] == target) {
            if (mid < range[0]) {
                range[0] = mid;
                searchRange(A, target, left, mid - 1, range);
            }
            if (mid > range[1]) {
                range[1] = mid;
                searchRange(A, target, mid + 1, right, range);
            }
        } else if (A[mid] < target) {
            searchRange(A, target, mid + 1, right, range);
        } else {
            searchRange(A, target, left, mid - 1, range);
        }
    }

    public static void main(String[] args) {
        L34 test = new L34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(test.searchRange(nums, 8)));


        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(test.searchRange(nums2, 2)));
    }
}
