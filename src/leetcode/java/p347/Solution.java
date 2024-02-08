package leetcode.java.p347;
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Sorting
 * | Time: O (n log n)
 * | Space: O (n)
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(new int[] { entry.getKey(), entry.getValue() });
        }
        int[] ans = new int[k];
        for (int i = 0; i < k && !pq.isEmpty(); ++i) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}