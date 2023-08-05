package algorithm.leetcodes1_50;

public class L42接雨水 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0, rightMax = 0;
        int ans = 0;
        // 接水量 = min(leftMax,rightMax) - height[i]
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

    public int trap2(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        // base case
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            // 转移方程
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 1, 3, 1, 4, 1, 2};
        System.out.println(new L42接雨水().trap(array));
    }
}
