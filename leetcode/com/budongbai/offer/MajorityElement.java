package com.budongbai.offer;

public class MajorityElement {
    /**
     * 摩尔投票法
     * <p>
     * 推论一： 若记 众数 的票数为 +1 ，非众数 的票数为 -1 ，则一定有所有数字的 票数和 > 0 。
     * <p>
     * 推论二： 若数组的前 a 个数字的 票数和 = 0 ，则 数组剩余 (n-a) 个数字的 票数和一定仍 >0 ，即后 (n-a) 个数字的 众数仍为 x 。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int votes = 1, x = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (votes == 0) {
                x = nums[i];
            }
            votes += nums[i] == x ? +1 : -1;
        }
        return x;
    }

    public int majorityElement(int[] nums) {
        int middle = nums.length >> 1;
        int start = 0, end = nums.length - 1;
        int index = quickSortRecursive(nums, start, end);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = quickSortRecursive(nums, start, end);
            } else {
                start = index + 1;
                index = quickSortRecursive(nums, start, end);
            }
        }

        return nums[index];

    }

    private static int quickSortRecursive(int[] arr, int start, int end) {
        if (start >= end)
            return start;
        int p = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            //找一个大于基准的
            while (arr[left] <= p && left < right)
                left++;
            //找一个小于基准的
            while (arr[right] >= p && left < right)
                right--;
            swap(arr, left, right);
        }
        //如果left位置的元素大于基准，就跟基准交换
        if (arr[left] > p)
            swap(arr, left, end);
        else
            left++;
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 3, 2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

}
