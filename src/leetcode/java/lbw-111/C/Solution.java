package leetcode.java.lbw-111.C;
// https://leetcode.com/contest/biweekly-contest-111/problems/sorting-three-groups/

import java.util.*;

/**
 * DFS
 * | Time: O (n)
 * | Space: O (1)
 */
public class Solution {
    private int n, ans;

    public int minimumOperations(List<Integer> nums) {
        n = ans = nums.size();
        findMin(nums, 0, 1, 0);
        return ans;
    }

    private void findMin(List<Integer> nums, int idx, int curGroup, int curCnt) {
        if (idx == n) {
            ans = Math.min(ans, curCnt);
            return;
        }

        if (nums.get(idx) < curGroup) {
            findMin(nums, idx + 1, curGroup, curCnt + 1);
        } else if (nums.get(idx) > curGroup) {
            findMin(nums, idx + 1, curGroup, curCnt + 1);
            findMin(nums, idx + 1, nums.get(idx), curCnt);
        } else {
            findMin(nums, idx + 1, curGroup, curCnt);
        }
    }
}
