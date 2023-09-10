package leetcode.lw362.A;
// https://leetcode.com/contest/weekly-contest-362/problems/points-that-intersect-with-cars/

import java.util.*;

/**
 * Brute Force
 * | Time: O(N(r-l))
 * | Space: O(1)
 */
public class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int ans= 0;
        int[] line= new int[101];
        for (List<Integer> car : nums) {
            int l= car.get(0), r= car.get(1);
            for (int i=l; i <= r; ++i) {
                ++line[i];
            }
        }
        for (int i=0; i <= 100; ++i) {
            if (line[i] > 0) ++ans;
        }
        return ans;
    }
}