package leetcode.p1337;
// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

import java.util.*;

/**
 * Sortings
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> arr= new ArrayList<>();
        for (int i= 0; i < mat.length; ++i) {
            int[] row= mat[i];
            int cnt= 0;
            for (int p : row) {
                if (p == 0) break;
                ++cnt;
            }
            arr.add(new int[]{cnt, i});
        }
        arr.sort((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] ans= new int[k];
        for (int i= 0; i < k; ++i) {
            ans[i]= arr.get(i)[1];
        }
        return ans;
    }
}
