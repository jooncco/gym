package leetcode.java.p1832;
// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class Solution {
    public boolean checkIfPangram(String sentence) {
        int bitmask = 0;
        for (char c : sentence.toCharArray()) {
            bitmask |= (1 << (c - 'a'));
        }
        return bitmask == (1 << 26) - 1;
    }
}