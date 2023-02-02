package leetcode.p953;
// https://leetcode.com/problems/verifying-an-alien-dictionary/

import java.util.Arrays;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        String[] tmp= words.clone();
        Arrays.sort(tmp, (a,b) -> {;
            for (int i=0; i < Math.min(a.length(), b.length()); ++i) {
                int idxA= order.indexOf(a.charAt(i)), idxB= order.indexOf(b.charAt(i));
                if (idxA == idxB) continue;
                return idxA-idxB;
            }
            return a.length()-b.length();
        });
        for (int i=0; i < tmp.length; ++i) {
            if (!tmp[i].equals(words[i])) return false;
        }
        return true;
    }
}