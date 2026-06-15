package stacks;

import java.util.Stack;

public class MinStack {

    Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            int[] top = stack.peek();
            int min = Math.min(top[1], val);
            stack.push(new int[] {val, min});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
