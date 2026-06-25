package priorityqueue;

import java.util.PriorityQueue;

/**
 *
 * Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
 *
 * By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
 *
 * Follow-up: Can you solve it without sorting?
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,5,4], k = 2
 *
 * Output: 4
 * Example 2:
 *
 * Input: nums = [2,3,1,1,5,5,4], k = 3
 *
 * Output: 4
 *
 */
public class KthLargestInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if (k > nums.length) return -1;

        for (int num : nums) {
            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
