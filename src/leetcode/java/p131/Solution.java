package leetcode.java.p131;
// https://leetcode.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>(), 0);
        return ans;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; ++i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    private void dfs(String s, List<String> palindromes, int idx) {
        if (idx > s.length()) {
            ans.add(new ArrayList<>(palindromes));
            return;
        }
        for (int i = idx + 1; i < s.length(); ++i) {
            if (isPalindrome(s.substring(idx, i))) {
                palindromes.add(s.substring(idx, i));
                dfs(s, palindromes, i);
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }
}