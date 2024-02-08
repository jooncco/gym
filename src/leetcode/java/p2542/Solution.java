package leetcode.java.p2542;
// https://leetcode.com/problems/maximum-subsequence-score/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Priority Queue
 * | Time: O (n log n)
 * | Space: O (n)
 */
public class Solution {
    public long maxScore(int[] A, int[] B, int k) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            arr.add(new int[] { A[i], B[i] });
        }
        arr.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);

        long sum = 0, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k - 1; ++i) {
            pq.add(arr.get(i)[0]);
            sum += arr.get(i)[0];
        }
        for (int i = k - 1; i < arr.size(); ++i) {
            sum += arr.get(i)[0];
            pq.add(arr.get(i)[0]);

            ans = Math.max(ans, sum * arr.get(i)[1]);
            if (!pq.isEmpty())
                sum -= pq.poll();
        }
        return ans;
    }
}