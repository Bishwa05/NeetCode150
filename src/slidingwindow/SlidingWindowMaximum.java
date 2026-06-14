package slidingwindow;

import java.sql.Array;
import java.util.*;

/**
 *
 * You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.
 *
 * Return a list that contains the maximum element in the window at each step.
 *
 * Example 1:
 *
 * Input: nums = [1,2,1,0,4,2,6], k = 3
 *
 * Output: [2,2,4,4,6]
 *
 * Explanation:
 * Window position            Max
 * ---------------           -----
 * [1  2  1] 0  4  2  6        2
 *  1 [2  1  0] 4  2  6        2
 *  1  2 [1  0  4] 2  6        4
 *  1  2  1 [0  4  2] 6        4
 *  1  2  1  0 [4  2  6]       6
 *
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }
                output[idx++] = heap.peek()[0];
            }
        }
        return output;
    }


    // Using dqueue
        public int[] maxSlidingWindow2(int[] nums, int k) {
            int n = nums.length;
            int[] output = new int[n - k + 1];
            Deque<Integer> q = new LinkedList<>();
            int l = 0, r = 0;

            while (r < n) {
                while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                    q.removeLast();
                }
                q.addLast(r);

                if (l > q.getFirst()) {
                    q.removeFirst();
                }

                if ((r + 1) >= k) {
                    output[l] = nums[q.getFirst()];
                    l++;
                }
                r++;
            }

            return output;
        }


    public static void main(String[] args) {
        int[] nums = {1,2,7,0,4,2,6};
        int k = 3;
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        Arrays.stream(s.maxSlidingWindow2(nums, k)).forEach(e -> System.out.println(e));

    }
}
