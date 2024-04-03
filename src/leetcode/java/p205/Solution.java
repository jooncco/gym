package leetcode.java.p205;
// https://leetcode.com/problems/isomorphic-strings/

import java.util.*;

/**
 * Data Structures
 * Time: O(n)
 * Space: O(n)
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // trivial case
        if (s.length() != t.length()) {
            return false;
        }
        // store mappings and if it's a taken character
        Map<Character, Character> map = new HashMap<>();
        Set<Character> taken = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (taken.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                taken.add(t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}