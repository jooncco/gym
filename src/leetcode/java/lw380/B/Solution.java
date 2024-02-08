package leetcode.java.lw380.B;
// https://leetcode.com/contest/weekly-contest-380/problems/find-beautiful-indices-in-the-given-array-i/

import java.util.*;

/**
 * Two Pointers
 * | Time: O(|s|(|a| + |b|))
 * | Space: O(|s|)
 */
public class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (i + a.length() <= s.length() && s.substring(i, i + a.length()).equals(a)) {
                A.add(i);
            }
            if (i + b.length() <= s.length() && s.substring(i, i + b.length()).equals(b)) {
                B.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        int bIdx = 0;
        for (int idx : A) {
            while (bIdx < B.size() && B.get(bIdx) < idx - k)
                ++bIdx;
            if (bIdx == B.size())
                break;
            if (idx + k >= B.get(bIdx))
                ans.add(idx);
        }
        return ans;
    }
}