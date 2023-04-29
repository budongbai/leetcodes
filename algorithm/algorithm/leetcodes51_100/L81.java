package algorithm.leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月28日下午7:24:13
 */
public class L81 {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
            //中间元素大于最左边元素，则左边的子数组是有序数组
            if (nums[start] < nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            //中间元素小于最左边元素，则右边的子数组是有序数组
            else if (nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
                //如果中间元素等于最左边元素，则start++;
            } else {
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L81 test = new L81();
        int[] nums = {1, 1, 3, 1};
        boolean res = test.search(nums, 3);
        System.out.println(res);
    }
}
