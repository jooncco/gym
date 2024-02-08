package leetcode.java.p804;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--.." };
    private Set<String> transformations;

    public int uniqueMorseRepresentations(String[] words) {
        transformations = new HashSet<>();
        for (final String word : words) {
            transformations.add(toMorseCode(word));
        }
        return transformations.size();
    }

    private String toMorseCode(String word) {
        String transformation = "";
        for (char c : word.toCharArray()) {
            transformation += morseCode[c - 'a'];
        }
        return transformation;
    }
}
