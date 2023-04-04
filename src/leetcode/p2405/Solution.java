package leetcode.p2405;
// https://leetcode.com/problems/optimal-partition-of-string/

public class Solution {
    public int partitionString(String s) {
        int ans= 0;
        boolean[] existInThisSubstring= new boolean[26];
        for (char c : s.toCharArray()) {
            if (existInThisSubstring[c-'a']) {
                ++ans;
                existInThisSubstring= new boolean[26];
            }
            existInThisSubstring[c-'a']= true;
        }
        return ans;
    }
}