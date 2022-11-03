package leetcode.p2131;
// https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, int[]> map;
    private int[] sameLetterWordCount;

    public int longestPalindrome(String[] words) {
        map= new HashMap<>();
        for (int i=0; i < 26; ++i) map.put(i, new int[26]);
        sameLetterWordCount= new int[26];
        for (String word : words) {
            int key= word.charAt(0)-'a';
            if (key == word.charAt(1)-'a') ++sameLetterWordCount[key];
            else {
                int[] charCount= map.get(key);
                ++charCount[word.charAt(1)-'a'];
                map.put(key, charCount);
            }
        }

        int ans= 0;
        for (int i=0; i < 26; ++i) {
            int[] charCount= map.get(i);
            for (int j=0; j < 26; ++j) {
                int matchingWordCount= map.get(j)[i];
                if (Math.min(charCount[j], matchingWordCount) > 0) {
                    int used= Math.min(charCount[j], matchingWordCount);
                    ans += used*4;
                    charCount[j] -= used;
                    map.get(j)[i] -= used;
                }
            }
        }
        for (int i=0; i < 26; ++i) {
            int pairCnt= sameLetterWordCount[i]/2;
            ans += pairCnt*4;
            sameLetterWordCount[i] -= pairCnt*2;
        }
        for (int i=0; i < 26; ++i) {
            if (sameLetterWordCount[i] > 0) {
                ans += 2;
                --sameLetterWordCount[i];
                break;
            }
        }
        return ans;
    }
}