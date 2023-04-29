package algorithm.leetcodes101_150;

/**
 * 移动零
 */
public class L283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;

        while (right < n) {
            // 左指针指向0，右指针找下一个不是0的数，交换
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


    public static void main(String[] args) {
        L283 demo = new L283();
        int[] nums = {0, 1, 0, 2, 34, 0, 3};
        demo.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
