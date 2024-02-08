package leetcode.java.p2785;
// https://leetcode.com/problems/sort-vowels-in-a-string/

import java.util.*;

/**
 * Sortings
 * | Time: O(n log(n))
 * | Space: O(n)
 */
public class Solution {
    public String sortVowels(String s) {
        final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        List<Character> vowelsInS = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (VOWELS.contains(c)) {
                vowelsInS.add(c);
            }
        }
        vowelsInS.sort(Character::compare);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (VOWELS.contains(s.charAt(i))) {
                sb.append(vowelsInS.get(idx++));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}