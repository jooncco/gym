package leetcode.p491;
// https://leetcode.com/problems/non-decreasing-subsequences/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private Set<List<Integer>> ret= new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        for (int i=0; i < nums.length; ++i) {
            for (int j=i+1; j < nums.length; ++j) {
                if (nums[i] <= nums[j]) {
                    List<Integer> list= Arrays.asList(nums[i], nums[j]);
                    ret.add(list);
                    dfs(nums, list, j+1);
                }
            }
        }
        return new ArrayList<>(ret);
    }

    private void dfs(int[] nums, List<Integer> list, int curIdx) {
        if (curIdx >= nums.length) return;
        if (list.get(list.size()-1) <= nums[curIdx]) {
            List<Integer> newList= new ArrayList<>(list);
            newList.add(nums[curIdx]);
            ret.add(newList);
            dfs(nums, newList, curIdx+1);
        }
        dfs(nums, list, curIdx+1);
    }
}