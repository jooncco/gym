package leetcode.java.p2306;
// https://leetcode.com/problems/naming-a-company/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] suffixes = new HashSet[26];
        for (int i = 0; i < 26; ++i) {
            suffixes[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            suffixes[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long ans = 0;
        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                long cntA = 0, cntB = 0;
                for (String suffix : suffixes[i]) {
                    if (!suffixes[j].contains(suffix))
                        ++cntA;
                }
                for (String suffix : suffixes[j]) {
                    if (!suffixes[i].contains(suffix))
                        ++cntB;
                }
                ans += cntA * cntB;
            }
        }
        return 2 * ans;
    }
}