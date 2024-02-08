package leetcode.java.p1220;
// https://leetcode.com/problems/count-vowels-permutation/

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    private final int M = 1000000007;
    private final List<Character> vowels = List.of('s', 'a', 'e', 'i', 'o', 'u');
    private final Map<Character, List<Character>> next = Map.of(
            's', List.of('a', 'e', 'i', 'o', 'u'),
            'a', List.of('e', 'i', 'u'),
            'e', List.of('a', 'i'),
            'i', List.of('e', 'o'),
            'o', List.of('i'),
            'u', List.of('i', 'o'));
    private int[][] cache;

    public int countVowelPermutation(int n) {
        if (n == 1)
            return 5;

        cache = new int[6][n + 1];
        for (int i = 0; i < 6; ++i)
            Arrays.fill(cache[i], -1);
        return howMany('s', n);
    }

    private int howMany(final char prev, final int len) {
        if (len == 1)
            return next.get(prev).size();

        int vowelIdx = vowels.indexOf(prev);
        if (cache[vowelIdx][len] >= 0)
            return cache[vowelIdx][len];

        cache[vowelIdx][len] = 0;
        for (char nextChar : next.get(prev)) {
            cache[vowelIdx][len] = (cache[vowelIdx][len] + howMany(nextChar, len - 1)) % M;
        }
        return cache[vowelIdx][len];
    }
}
