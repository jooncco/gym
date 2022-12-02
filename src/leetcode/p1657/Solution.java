package leetcode.p1657;
// https://leetcode.com/problems/determine-if-two-strings-are-close/

import java.util.LinkedList;
import java.util.List;
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] charSet= new int[2];
        for (char c : word1.toCharArray()) charSet[0] |= (1<<(c-'a'));
        for (char c : word2.toCharArray()) charSet[1] |= (1<<(c-'a'));
        if (charSet[0] != charSet[1]) return false;

        int[][] occurrence= new int[2][26];
        for (char c : word1.toCharArray()) occurrence[0][c-'a']++;
        for (char c : word2.toCharArray()) occurrence[1][c-'a']++;
        List<Integer> count= new LinkedList<>();
        for (int i=0; i < 26; ++i) count.add(occurrence[0][i]);
        for (int i=0; i < 26; ++i) {
            if (!count.contains(occurrence[1][i])) return false;
            count.remove(count.indexOf(occurrence[1][i]));
        }
        return true;
    }
}