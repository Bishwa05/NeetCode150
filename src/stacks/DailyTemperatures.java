package stacks;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] out = new int[n];
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
                out[indexStack.peek()] = i - indexStack.pop();
            }

            indexStack.push(i);

        }
        return out;
    }

    // Another approach

    /**
     * Create a result list filled with zeros.
     * Use a stack to store pairs of (temperature, index) for days that haven't found a warmer day yet.
     * Iterate through the temperature list:
     * While the stack is not empty and the current temperature is warmer than the top of the stack:
     * Pop the top element.
     * Compute how many days passed and update the result.
     * Push the current day onto the stack.
     * Return the filled result list.
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;
    }
}
