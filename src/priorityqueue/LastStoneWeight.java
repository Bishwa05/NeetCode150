package priorityqueue;

import java.util.PriorityQueue;

/**
 *
 * https://neetcode.io/problems/last-stone-weight
 *
 * You are given an array of integers stones where stones[i] represents the weight of the ith stone.
 *
 * We want to run a simulation on the stones as follows:
 *
 * At each step we choose the two heaviest stones, with weight x and y and smash them togethers
 * If x == y, both stones are destroyed
 * If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * Continue the simulation until there is no more than one stone remaining.
 *
 * Return the weight of the last remaining stone or return 0 if none remain.
 *
 * Example 1:
 *
 * Input: stones = [2,3,6,2,4]
 *
 * Output: 1
 *
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            heap.offer(stone);
        }

        while (heap.size()> 1) {
            int x1 = heap.poll();
            int x2 = heap.poll();

            int val = x1 - x2;
            heap.offer(val);
        }

        return heap.peek();
    }
}
