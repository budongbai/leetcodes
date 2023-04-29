package algorithm.leetcodes1_50;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年7月7日下午4:59:11
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                int i = mid;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                int j = mid;
                while (j < nums.length - 1 && nums[j] == target) {
                    j++;
                }
                return new int[]{++i, --j};
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
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
    }
}
