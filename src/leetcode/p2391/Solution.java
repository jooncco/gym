package leetcode.p2391;
// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

import java.util.*;

/**
 * Implementation
 * | Time: O(n |garbage[i]|)
 * | Space: O(1)
 */
public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        List<Character> targets= List.of('G', 'M', 'P');
        int[] N= new int[targets.size()];
        for (int i=0; i < garbage.length; ++i) {
            for (int j=0; j < targets.size(); ++j) {
                if (garbage[i].contains(targets.get(j)+"")) N[j]= i;
            }
        }
        int ans= 0;
        for (int j=0; j < targets.size(); ++j) {
            ans += computeTime(garbage, travel, targets.get(j), N[j]);
        }
        return ans;
    }

    private int computeTime(String[] garbage, int[] travel, char target, int n) {
        int cnt= 0;
        for (int i = 0; i <= n; i++) {
            for (char c : garbage[i].toCharArray()) {
                if (c == target) ++cnt;
            }
            if (i < n) cnt += travel[i];
        }
        return cnt;
    }
}