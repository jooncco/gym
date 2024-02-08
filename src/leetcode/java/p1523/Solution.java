package leetcode.java.p1523;
// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

public class Solution {
    public int countOdds(int l, int r) {
        return l % 2 == 0 ? (r - l + 1) / 2 : (r - l) / 2 + 1;
    }
}