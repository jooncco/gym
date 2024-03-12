package leetcode.java.p791;
// https://leetcode.com/problems/custom-sort-string/

/**
 * Sortings
 * Time: O(|S| + |order|)
 * Space: O(|S|)
 */
public class Solution {
    public String customSortString(String order, String S) {
        // Count characters in S
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            ++count[c - 'a'];
        }

        // Find and append characters in 'order' string
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                --count[c - 'a'];
            }
        }

        // Append the remaining
        for (int i = 0; i < 26; ++i) {
            while (count[i] > 0) {
                sb.append((char) ('a' + i));
                --count[i];
            }
        }
        return sb.toString();
    }
}