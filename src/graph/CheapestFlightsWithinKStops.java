package graph;

import java.util.PriorityQueue;

/**
 * There are n airports, labeled from 0 to n - 1, which are connected by some flights. You are given an array flights where flights[i] = [from_i, to_i, price_i] represents a one-way flight from airport from_i to airport to_i with cost price_i. You may assume there are no duplicate flights and no flights from an airport to itself.
 *
 * You are also given three integers src, dst, and k where:
 *
 * src is the starting airport
 * dst is the destination airport
 * src != dst
 * k is the maximum number of stops you can make (not including src and dst)
 * Return the cheapest price from src to dst with at most k stops, or return -1 if it is impossible.
 *
 * Input: n = 4, flights = [[0,1,200],[1,2,100],[1,3,300],[2,3,100]], src = 0, dst = 3, k = 1
 *
 * Output: 500
 * Explanation:
 * The optimal path with at most 1 stop from airport 0 to 3 is shown in red, with total cost 200 + 300 = 500.
 * Note that the path [0 -> 1 -> 2 -> 3] costs only 400, and thus is cheaper, but it requires 2 stops, which is more than k.
 *
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] priceMat = new int[n][n];
        for (int[] flight : flights) {
            priceMat[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        minHeap.offer(new int[] {0, src, k+1});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int price = curr[0];
            int place = curr[1];
            int remainingStop = curr[2];
            if (dst == place) return price;

            if (remainingStop > 0) {
                 for (int i = 0; i < n; i++) {
                     if (priceMat[place][i] > 0) {
                         minHeap.offer(new int[] {price + priceMat[place][i], i, remainingStop-1});
                     }
                 }
             }
        }
        return -1;
    }
}
