package twopointer;

/**
 * You are given an array of non-negative integers height which represent an elevation map.
 * Each value height[i] represents the height of a bar, which has a width of 1.
 *
 * Return the maximum area of water that can be trapped between the bars.
 *
 * Input: height = [0,2,0,3,1,0,1,3,2,1]
 * Output: 9
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water = water + leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water = water + rightMax - height[right];
            }
        }
        return water;
    }
}
