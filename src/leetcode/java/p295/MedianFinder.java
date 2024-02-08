package leetcode.java.p295;
// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> small, large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() + small.peek()) / 2.0;
    }
}