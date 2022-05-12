package leetcode.p47;
// https://leetcode.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    private Set<List<Integer>> ans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n= nums.length;
        ans= new HashSet<>();
        List<Integer> permutation= new LinkedList<>();
        boolean used[]= new boolean[n];
        generateAns(nums, permutation, used, 0);
        return ans.stream().collect(Collectors.toList());
    }

    private void generateAns(int nums[], List<Integer> cur, boolean used[], int idx) {
        int n= nums.length;
        if (idx == n) {
            if (!ans.contains(cur)) ans.add(new ArrayList(cur));
            return;
        }

        for (int i=0; i < n; ++i) {
            if (used[i]) continue;
            cur.add(nums[i]);
            used[i]= true;
            generateAns(nums, cur, used, idx+1);
            used[i]= false;
            cur.remove(cur.size()-1);
        }
    }
}