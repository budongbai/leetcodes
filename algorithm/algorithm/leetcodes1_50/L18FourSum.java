package algorithm.leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author budongbai
 * @version 2017年6月30日上午10:57:07
 */
public class L18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return res;
        int[][] sum2 = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum2[i][j] = nums[i] + nums[j];
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(target - sum2[i][j])) {
                    List<Integer> temp = map.get(target - sum2[i][j]);
                    for (int m = 0; m < temp.size(); m = m + 2) {
                        if (temp.get(m) != i && temp.get(m + 1) != i && temp.get(m) != j && temp.get(m + 1) != j) {
                            List<Integer> l = Arrays.asList(nums[temp.get(m)], nums[temp.get(m + 1)], nums[i], nums[j]);
                            l.sort(null);
                            if (!res.contains(l)) {
                                res.add(l);
                            }
                        }
                    }
                }
                List<Integer> temp = map.get(sum2[i][j]);
                if (temp == null) {
                    temp = new ArrayList<Integer>();
                }
                temp.add(i);
                temp.add(j);
                map.put(sum2[i][j], temp);
            }
        }

        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target in
     * sorted array nums[] between indices low and high. If there are, add all
     * of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target in
     * sorted array nums[] between indices low and high. If there are, add all
     * of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }

    public List<List<Integer>> fourSum3(int[] nums, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break; // first candidate too large, search finished
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue; // first candidate too small
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // prevents duplicate result in ans list
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break; // second candidate too large
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target)
                    continue; // second candidate too small
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // prevents duplicate results in ans list
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1])
                            low++; // skipping over duplicate on low
                        while (low < high && nums[high] == nums[high - 1])
                            high--; // skipping over duplicate on high
                        low++;
                        high--;
                    }
                    // move window
                    else if (sum < target)
                        low++;
                    else
                        high--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L18FourSum test = new L18FourSum();
        //	int[] nums = { 1, 0, -1, 0, -2, 2 };
        // System.out.println(test.fourSum(nums, 0));
        // System.out.println(test.fourSum(new int[]{0,0,0,0}, 1));
        System.out.println(test.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }

}
