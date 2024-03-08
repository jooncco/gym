package leetcode.java.p3005;
// https://leetcode.com/problems/count-elements-with-maximum-frequency/

/**
 * Ad hoc
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int maxFrequencyElements(int[] nums) {
        final int MAX_VAL= 100;
        int[] freq= new int[MAX_VAL + 1];
        for (int num : nums) {
            freq[num]++;
        }
        int maxFreq = 0;
        for (int i=1; i <= MAX_VAL; ++i) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
            }
        }
        int ans= 0;
        for (int i=1; i <= MAX_VAL; ++i) {
            if (freq[i] == maxFreq) {
                ans += freq[i];
            }
        }
        return ans;
    }
}