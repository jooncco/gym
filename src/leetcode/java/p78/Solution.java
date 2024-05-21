package leetcode.java.p78;
// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 * Time: O(2^2n)
 * Space: O(2^n)
 */
public class Solution {
    private List<List<Integer>> ret;

    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0);
        return ret;
    }

    private void dfs(int[] nums, List<Integer> list, int idx) {
        if (idx == nums.length) {
            List<Integer> currentList = new ArrayList<>(list);
            if (!ret.contains(currentList)) {
                ret.add(currentList);
            }
            return;
        }

        dfs(nums, list, idx + 1);
        list.add(nums[idx]);
        dfs(nums, list, idx + 1);
        list.remove(list.size() - 1);
    }
}