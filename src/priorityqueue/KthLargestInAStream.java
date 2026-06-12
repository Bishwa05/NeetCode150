package priorityqueue;

import java.util.PriorityQueue;

/**
 * https://neetcode.io/problems/kth-largest-integer-in-a-stream
 *
 * Kth Largest Element in a Stream
 * Easy
 * Topics
 * Company Tags
 * Hints
 * Design a class to find the kth largest integer in a stream of values, including duplicates. E.g. the 2nd largest from [1, 2, 3, 3] is 3. The stream is not necessarily sorted.
 *
 * Implement the following methods:
 *
 * constructor(int k, int[] nums) Initializes the object given an integer k and the stream of integers nums.
 * int add(int val) Adds the integer val to the stream and returns the kth largest integer in the stream.
 * Example 1:
 *
 * Input:
 * ["KthLargest", [3, [1, 2, 3, 3]], "add", [3], "add", [5], "add", [6], "add", [7], "add", [8]]
 *
 * Output:
 * [null, 3, 3, 3, 5, 6]
 *
 */
public class KthLargestInAStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }


    // Another approach which was giving better time complexity in neetcode

//    PriorityQueue<Integer> heap;
//    List<Integer> list;
//    int k;
//
//    public KthLargest(int k, int[] nums) {
//        heap = new PriorityQueue<>((a, b) -> b-a);
//        list = new ArrayList<>();
//        this.k = k;
//
//        for (int num : nums) {
//            heap.offer(num);
//        }
//    }
//
//    public int add(int val) {
//        int x = k;
//        heap.offer(val);
//
//        while(x > 1) {
//            list.add(heap.poll());
//            x--;
//        }
//
//        int res = heap.peek();
//
//        while(list.size()>0) {
//            heap.offer(list.remove(0));
//        }
//        return res;
// }
}
