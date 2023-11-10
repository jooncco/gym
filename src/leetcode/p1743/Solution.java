package leetcode.p1743;
// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

import java.util.*;

/**
 * Constructive Algorithms
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n= adjacentPairs.length+1;
        Map<Integer, List<Integer>> adj= new HashMap<>();
        for (int[] pair : adjacentPairs) {
            adj.computeIfAbsent(pair[0], x -> new ArrayList<>()).add(pair[1]);
            adj.computeIfAbsent(pair[1], x -> new ArrayList<>()).add(pair[0]);
        }
        int leftEnd= 987654321;
        for (int key : adj.keySet()) {
            if (adj.get(key).size() == 1) {
                leftEnd= key;
                break;
            }
        }
        int[] ans= new int[n];
        ans[0]=leftEnd;
        ans[1]= adj.get(leftEnd).get(0);
        for (int i= 2; i < n; i++) {
            ans[i]= adj.get(ans[i-1]).get(0) == ans[i-2] 
                ? adj.get(ans[i-1]).get(1) 
                : adj.get(ans[i-1]).get(0);
        }
        return ans;
    }
}