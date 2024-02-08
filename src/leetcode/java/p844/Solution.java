package leetcode.java.p844;
// https://leetcode.com/problems/backspace-string-compare/

/**
 * Strings
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        int idxS = s.length() - 1, idxT = t.length() - 1;
        while (idxS > -1 && idxT > -1) {
            System.out.println("idxS: " + idxS + " / idxT: " + idxT);
            if (s.charAt(idxS) == '#') {
                idxS = nextLowercaseIdx(s, idxS);
                continue;
            }
            if (t.charAt(idxT) == '#') {
                idxT = nextLowercaseIdx(t, idxT);
                continue;
            }
            if (s.charAt(idxS) != t.charAt(idxT)) {
                return false;
            }
            --idxS;
            --idxT;
        }
        if (idxS > -1 && s.charAt(idxS) == '#') {
            idxS = nextLowercaseIdx(s, idxS);
        }
        if (idxT > -1 && t.charAt(idxT) == '#') {
            idxT = nextLowercaseIdx(t, idxT);
        }
        return idxS < 0 && idxT < 0;
    }

    private int nextLowercaseIdx(String str, int idx) {
        int cnt = 0;
        while (idx > -1 && (str.charAt(idx) == '#' || cnt > 0)) {
            if (str.charAt(idx) == '#')
                ++cnt;
            else
                --cnt;
            --idx;
        }
        return idx;
    }
}