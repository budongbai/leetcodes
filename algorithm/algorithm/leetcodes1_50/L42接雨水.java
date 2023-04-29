package algorithm.leetcodes1_50;

public class L42接雨水 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                ans += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {0,2,1,1,3,1,4,1,2};
        System.out.println(new L42接雨水().trap(array));
    }
}
