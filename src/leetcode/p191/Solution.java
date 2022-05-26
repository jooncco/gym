package leetcode.p191;

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