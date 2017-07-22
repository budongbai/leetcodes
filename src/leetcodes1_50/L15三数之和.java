package leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年6月29日下午3:16:57
 */
public class L15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l = null;
        for (int i = 0; i < nums.length - 2; i++) {
            //这里剪枝了啊，为什么还超时
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1, k = nums.length - 1; j < k; ) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        //剪枝后就没有必要再判断一回是否包含这个元素了
                        //if (!list.contains(l))
                        list.add(l);
                        //剪枝
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    }

                }
            }
        }

        return list;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(new L15三数之和().threeSum(arr));
        int[] arr2 = {0, 0, 0};
        System.out.println(new L15三数之和().threeSum(arr2));
    }
}
