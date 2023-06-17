package leetcode.p1187;
// https://leetcode.com/problems/make-array-strictly-increasing/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming (Top-down)
 * | Time: O (nm)
 * | Space: O (n)
 */
public class Solution {
    private static final int INF= 2001;
    private int ans= INF;
    private Map<String, Integer> cache= new HashMap<>();

    public int makeArrayIncreasing(int[] A, int[] B) {
        Arrays.sort(B);
        ans= dfs(A, B, -1, 0, 0);
        return ans == INF ? -1 : ans;
    }

    private int dfs(int[] A, int[] B, int prev, int idxA, int idxB) {
        if (idxA == A.length) return 0;

        String key= prev+","+idxA+","+idxB;
        if (cache.get(key) != null) return cache.get(key);
        int ret= INF;
        if (prev < A[idxA]) {
            ret= dfs(A, B, A[idxA], idxA+1, idxB);
        }
        while (idxB < B.length && B[idxB] <= prev) ++idxB;
        if (idxB < B.length) {
            ret= Math.min(ret, 1 + dfs(A, B, B[idxB], idxA+1, idxB));
        }
        cache.put(key, ret);
        return ret;
    }
}
