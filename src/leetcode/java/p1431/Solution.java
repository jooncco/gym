package leetcode.java.p1431;
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.LinkedList;
import java.util.List;

/**
 * Math
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        List<Boolean> result = new LinkedList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandy);
        }
        return result;
    }
}