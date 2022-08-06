package leetcode.p458;
// https://leetcode.com/problems/poor-pigs/

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rowSize= minutesToTest/minutesToDie + 1;
        int pigs= -1, limit;
        do {
            ++pigs;
            limit= 1;
            for (int i=0; i < pigs; ++i) {
                limit *= rowSize;
            }
        } while (limit < buckets);
        return pigs;
    }
}