package leetcode.java.p383;
// https://leetcode.com/problems/ransom-note/

public class Solution {
    private final int NUM_OF_LETTERS = 26;

    public boolean canConstruct(final String ransomNote, final String magazine) {
        int[] ransomNoteLetterCnt = countLetters(ransomNote);
        int[] magazineLetterCnt = countLetters(magazine);
        for (int i = 0; i < NUM_OF_LETTERS; ++i) {
            if (ransomNoteLetterCnt[i] > magazineLetterCnt[i])
                return false;
        }
        return true;
    }

    private int[] countLetters(final String str) {
        int[] cnt = new int[NUM_OF_LETTERS];
        for (char c : str.toCharArray()) {
            ++cnt[c - 'a'];
        }
        return cnt;
    }
}