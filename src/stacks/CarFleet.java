package stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://neetcode.io/problems/car-fleet
 *
 * There are n cars traveling to the same destination on a one-lane highway.
 *
 * You are given two arrays of integers position and speed, both of length n.
 *
 * position[i] is the position of the ith car (in miles)
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 *
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 *
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 *
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 *
 * Return the number of different car fleets that will arrive at the destination.
 *
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 1;
        Stack<Double> stack = new Stack<>();
        double prevTime = (double) (target - pair[0][0])/pair[0][1];
        for(int[] p : pair) {
            stack.push((double) (target - p[0])/p[1]);

            if (stack.size() >=2 && stack.peek() <= stack.get(stack.size()-2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
