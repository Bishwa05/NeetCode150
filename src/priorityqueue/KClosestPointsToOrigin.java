package priorityqueue;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Point {
        int x;
        int y;
        double d;
        Point(int x, int y, double d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> Double.compare(b.d, a.d));

        for (int[] point : points) {
            double d = distance(point[0], point[1]);
            System.out.println(d);
            heap.offer(new Point(point[0], point[1], d));

            if (heap.size() > k) {
                heap.poll();
            }
        }

        for(int i = k-1; i >= 0; i--) {
            Point point = heap.poll();
            res[i][0] = point.x;
            res[i][1] = point.y;
        }

        return res;
    }

    private double distance(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{0,2},{2,2}};
        int k = 1;
        KClosestPointsToOrigin k1 = new KClosestPointsToOrigin();
        k1.kClosest(points, k);

    }
}
