package leetcode.p228;
// https://leetcode.com/problems/summary-ranges/

import java.util.ArrayList;
import java.util.List;

/**
 * Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans= new ArrayList<>();
        if (nums.length > 0) {
            int l= nums[0], cnt= 1;
            for (int i=1; i < nums.length; ++i) {
                if (l+cnt < nums[i]) {
                    ans.add(cnt == 1 ? l + "" : l + "->" + (l+cnt-1));
                    l= nums[i];
                    cnt= 1;
                } else {
                    ++cnt;
                }
            }
            ans.add(cnt == 1 ? l + "" : l + "->" + (l+cnt-1));
        }
        return ans;
    }
}