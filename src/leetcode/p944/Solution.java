package leetcode.p944;
// https://leetcode.com/problems/delete-columns-to-make-sorted/

public class Solution {
    public int minDeletionSize(String[] strs) {
        int ans= 0;
        for (int col= 0; col < strs[0].length(); ++col) {
            int cur= strs[0].charAt(col)-'a';
            for (int row= 1; row < strs.length; ++row) {
                if (strs[row].charAt(col)-'a' < cur) {
                    ++ans;
                    break;
                }
                cur= strs[row].charAt(col)-'a';
            }
        }
        return ans;
    }
}