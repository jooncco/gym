package leetcode.p77;
// https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

/**
 * Depth First Search (Subset)
 * | Time: O (2^n)
 * | Space: O (n)
 */
public class Solution {
    List<List<Integer>> ans= new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, new ArrayList<>(), 1, 0);
        return ans;
    }

    private void dfs(int n, int k, List<Integer> cur, int idx, int cnt) {
        if (idx > n) {
            if (cnt == k) ans.add(new ArrayList<>(cur));
            return;
        }

        dfs(n, k, cur, idx+1, cnt);
        cur.add(idx);
        dfs(n, k, cur, idx+1, cnt+1);
        cur.remove(cur.size()-1);
    }
}