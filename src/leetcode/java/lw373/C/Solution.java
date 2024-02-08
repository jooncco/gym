package leetcode.java.lw373.C;
// https://leetcode.com/contest/weekly-contest-373/problems/make-lexicographically-smallest-array-by-swapping-elements/

import java.util.*;

/**
 * Sortings (Topological Sort)
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) { // n
            arr.add(new int[] { nums[i], i });
        }
        arr.sort((a, b) -> Integer.compare(a[0], b[0])); // n log(n)
        int[] ans = new int[n];
        int l = 0;
        PriorityQueue<Integer> indices = new PriorityQueue<>((a, b) -> a - b);
        indices.add(arr.get(0)[1]);
        for (int r = 1; r < n; ++r) { // O (n)
            int num = arr.get(r)[0], origIdx = arr.get(r)[1];
            if (num - arr.get(r - 1)[0] > limit) {
                while (!indices.isEmpty()) { // O (|indices|)
                    int idx = indices.poll(); // O (1)
                    ans[idx] = arr.get(l++)[0];
                }
            }
            indices.add(origIdx); // O (log(|indices|))
        }
        while (!indices.isEmpty()) {
            int idx = indices.poll();
            ans[idx] = arr.get(l++)[0];
        }
        return ans;
    }
}