package algorithm.leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月28日下午12:11:58
 */
public class L80 {
    // 从后往前移除，超过2个就移除
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int len = nums.length;
        int count = 1;
        int res = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count > 2) {
                    for (int j = i + 1; j < len - count + 2; j++) {
                        nums[j] = nums[j + count - 2];
                    }
                    res -= count - 2;
                }
                count = 1;
            }

        }
        if (count > 2) {

            for (int j = 0; j < len - count + 2; j++) {
                nums[j] = nums[j + count - 2];
            }
            res -= count - 2;
            count = 1;
        }
        return res;
    }

    // 机智做法啊
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        L80 test = new L80();
        int res = test.removeDuplicates2(nums);
        System.out.println(res);
    }
}
