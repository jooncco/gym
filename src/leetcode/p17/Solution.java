package leetcode.p17;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.*;

/**
 * DFS (Back Tracking)
 * | Time: 3^len
 * | Space: O (len)
 */
public class Solution {
    private final String[][] pad = { {},
            {}, { "a", "b", "c" }, { "d", "e", "f" },
            { "g", "h", "i" }, { "j", "k", "l" }, { "m", "n", "o" },
            { "p", "q", "r", "s" }, { "t", "u", "v" }, { "w", "x", "y", "z" } };
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        dfs(digits, 0, "");
        return ans;
    }

    private void dfs(String digits, int idx, String curStr) {
        if (idx == digits.length()) {
            ans.add(curStr);
            return;
        }

        String nextStr = curStr;
        for (String c : pad[digits.charAt(idx) - '0']) {
            nextStr = curStr + c;
            dfs(digits, idx + 1, nextStr);
        }
    }
}