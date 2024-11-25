package leetcode.java.p1431;
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.*;

/**
 * Math
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int mx= 0;
        for (int candy : candies) {
            mx= Math.max(mx, candy);
        }
        List<Boolean> ans= new ArrayList<>();
        for (int candy : candies) {
            ans.add(candy + extraCandies >= mx);
        }
        return ans;
    }
}