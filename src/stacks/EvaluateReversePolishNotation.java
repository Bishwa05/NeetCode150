package stacks;

import java.util.Stack;

/**
 * https://neetcode.io/problems/evaluate-reverse-polish-notation
 *
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 *
 * Return the integer that represents the evaluation of the expression.
 *
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1:
 *
 * Input: tokens = ["1","2","+","3","*","4","-"]
 *
 * Output: 5
 *
 * Explanation: ((1 + 2) * 3) - 4 = 5
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int val = stack.pop() + stack.pop();
                stack.push(val);
            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int val = b - a;
                stack.push(val);
            } else if (s.equals("*")) {
                int val = stack.pop() * stack.pop();
                stack.push(val);
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int val = b/a;
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
