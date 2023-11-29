package leetcode.p191;
// https://leetcode.com/problems/number-of-1-bits/

/**
 * Implementation, Bitmask
 * | Time: O(log(n))
 * | Space: O (1)
 */
public class Solution {
    public int hammingWeight(int n) {
        int weight= 0;
        while (n != 0) {
            weight += n&1;
            n >>>= 1;
        }
        return weight;
    }
}