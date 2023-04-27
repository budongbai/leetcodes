package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月29日上午10:33:19
 */
public class L11装水问题 {

    /**
     * 如何剪枝
     * 每次都是高度低的移动
     * 如果一个数组的结果应该是a10和a20，那么a21必定小于a10。为什么呢，我们分析如果a10小于a21的情况。
     * 如果a10小于a21，那么a10和a21的面积就至少是a10*（21-10）。
     * a10和a20的面积至多是a10*（20-10），那么a10和a21的面积大于a10和a20的面积，就不符合结果。
     * 所以a21必定小于a10。所以每次都是移动高度低的那个，我们才能得到最优结果。
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right && left >= 0 && right <= height.length - 1) {
            max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }


    public static void main(String[] args) {

        int[] height = {1, 1, 5, 4, 1, 3};
        System.out.println(new L11装水问题().maxArea(height));
    }

}
