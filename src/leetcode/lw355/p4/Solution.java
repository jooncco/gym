package leetcode.lw355.p4;
// https://leetcode.com/contest/weekly-contest-355/problems/count-paths-that-can-form-a-palindrome-in-a-tree/

import java.util.HashMap;
import java.util.List;

/**
 * Bitmask
 * | Time: O (26n)
 * | Space: O (n)
 */
public class Solution {
    private final int ROOT= 0;
    private int[] cache;

    public long countPalindromePaths(List<Integer> parent, String s) {
        int n= parent.size();
        cache= new int[n];
        for (int i=0; i < n; ++i) cache[i]= -1;
        var cnt= new HashMap<Integer, Integer>();
        for (int i=0; i < n; ++i) {
            int mask= getMask(parent, s, i);
            cnt.put(mask, cnt.getOrDefault(mask, 0)+1);
        }
        long ans= 0;
        for (int mask : cnt.keySet()) {
            long curCount= cnt.get(mask);
            ans += curCount*(curCount-1);
            for (int i=0; i < 26; ++i) {
                mask ^= (1<<i);
                ans += curCount*cnt.getOrDefault(mask, 0);
                mask ^= (1<<i);
            }
        }
        return ans/2;
    }

    private int getMask(List<Integer> parent, String s, int cur) {
        if (cur == ROOT) return 0;
        if (cache[cur] > -1) return cache[cur];

        return cache[cur]= getMask(parent, s, parent.get(cur)) ^ (1<<(s.charAt(cur)-'a'));
    }
}