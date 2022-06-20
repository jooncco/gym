package leetcode.p820;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<String> wordSet;

    public int minimumLengthEncoding(final String[] words) {
        wordSet= new HashSet<>(Arrays.asList(words));
        for (final String word : words) {
            for (int i=1; i < word.length(); ++i) {
                wordSet.remove(word.substring(i));
            }
        }
        int minLength= 0;
        for (String word : wordSet) {
            minLength += word.length()+1;
        }
        return minLength;
    }
}
