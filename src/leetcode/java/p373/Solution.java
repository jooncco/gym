package leetcode.java.p373;
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/submissions/980534011/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Priority Queue
 * | Time: O ( A.length + k log (A.length) )
 * | Space: O ( A.length )
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int a : A)
            pq.add(new int[] { a, B[0], 0 });
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0;
        while (cnt++ < k && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int idxB = cur[2];
            ans.add(List.of(cur[0], cur[1]));
            if (idxB < B.length - 1)
                pq.add(new int[] { cur[0], B[idxB + 1], idxB + 1 });
        }
        return ans;
    }
}