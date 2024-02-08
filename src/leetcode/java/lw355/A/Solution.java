package leetcode.java.lw355.A;
// https://leetcode.com/contest/weekly-contest-355/problems/split-strings-by-separator/

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == separator) {
                    if (sb.length() > 0) {
                        ans.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0)
                ans.add(sb.toString());
        }
        return ans;
    }
}