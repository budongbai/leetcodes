package algorithm.leetcodes101_150;

import java.util.HashSet;
import java.util.Set;


/**
 * 最长连续序列
 */
public class L128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int maxLength = 0;

        for(int num: nums){
            // 跳过了已经判断过的子序列,降低了时间复杂度
            if(!set.contains(num-1)){
                int next = num + 1;
                int curLength = 1;
                while(set.contains(next)){
                    curLength++;
                    next++;
                }
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}
