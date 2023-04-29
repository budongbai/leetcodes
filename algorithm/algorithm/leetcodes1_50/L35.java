package algorithm.leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年7月8日下午3:34:31
 */
public class L35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            //while(start<end){
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
            //System.out.println( mid + " "+ start + " "+ end);
        }
		/*if(start == end ){
			if(start == nums.length-1){
				if(target <= nums[start])
					return start;
				else
					return start+1;
			}else {
				if(target <=nums[end]){
					return start;
				}else{
					return start+1;
				}
			}
		}else if(start >end){
			return start;
		}*/

        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        L35 test = new L35();
        System.out.println(test.searchInsert(nums, 3));
    }
}
