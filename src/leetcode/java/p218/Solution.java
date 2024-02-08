package leetcode.java.p218;
// https://leetcode.com/problems/the-skyline-problem/

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new LinkedList<>();
        for (int[] building : buildings) {
            heights.add(new int[] { building[0], building[2] });
            heights.add(new int[] { building[1], -building[2] });
        }
        heights.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<List<Integer>> ans = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int prevMax = 0;
        pq.offer(prevMax);
        for (int[] height : heights) {
            if (height[1] > 0) {
                pq.offer(height[1]);
            } else {
                pq.remove(-height[1]);
            }
            int curMax = pq.isEmpty() ? 0 : pq.peek();
            if (curMax != prevMax) {
                ans.add(List.of(height[0], curMax));
                prevMax = curMax;
            }
        }
        return ans;
    }
}