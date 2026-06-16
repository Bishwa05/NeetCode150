package stacks;

/**
 * https://neetcode.io/problems/largest-rectangle-in-histogram
 *
 * You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
 *
 * Return the area of the largest rectangle that can be formed among the bars.
 *
 * Note: This chart is known as a histogram.
 *
 * Example 1:
 *
 * Input: heights = [7,1,7,2,2,4]
 *
 * Output: 8
 * Example 2:
 *
 * Input: heights = [1,3,7]
 *
 * Output: 7
 *
 */


import java.util.Stack;

/**
 * Algorithm is
 *
 * 1. Add to stack if curr val is >=top of stack
 * 2. Otherwise keep removing from stack till a smaller or equal number found.
 * 3. Calculate Area every time you remove
 *         if stack is empty
 *              area = input[top] * i
 *         else
 *              area = input[top]* (i - stack_top -1)
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while(i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() -1);
                }

                maxArea = Math.max(area, maxArea);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stack.peek() -1);
            }

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
