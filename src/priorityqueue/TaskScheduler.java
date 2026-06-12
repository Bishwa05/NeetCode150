package priorityqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * https://neetcode.io/problems/task-scheduling
 *
 * You are given an array of CPU tasks tasks, where tasks[i] is an uppercase english character from A to Z. You are also given an integer n.
 *
 * Each CPU cycle allows the completion of a single task, and tasks may be completed in any order.
 *
 * The only constraint is that identical tasks must be separated by at least n CPU cycles, to cooldown the CPU.
 *
 * Return the minimum number of CPU cycles required to complete all tasks.
 *
 * Example 1:
 *
 * Input: tasks = ["X","X","Y","Y"], n = 2
 *
 * Output: 5
 * Explanation: A possible sequence is: X -> Y -> idle -> X -> Y.
 *
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","C"], n = 3
 *
 * Output: 9
 *
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.offer(cnt);
            }
        }

        int time = 0;
        Queue<int[]> coolQ = new LinkedList<>();
        while (!maxHeap.isEmpty() || !coolQ.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = coolQ.peek()[1];
            } else {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    coolQ.offer(new int[]{cnt, time + n});
                }
            }

            if (!coolQ.isEmpty() && coolQ.peek()[1] == time) {
                maxHeap.offer(coolQ.poll()[0]);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] {'A','A','A','B','C'};
        int n = 3;
        TaskScheduler t = new TaskScheduler();
        System.out.println(t.leastInterval(tasks, n));
    }
}
