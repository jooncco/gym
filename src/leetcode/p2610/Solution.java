package leetcode.p2610;
// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

import java.util.*;

/**
 * Sortings, Greedy
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret= new ArrayList<>();
        int r= 0;
        for (int i=0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) ++r;
            else r= 0;
            if (ret.size() == r) ret.add(new ArrayList<>());
            ret.get(r).add(nums[i]);
        }
        return ret;
    }
}