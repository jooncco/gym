package leetcode.java.p838;
// https://leetcode.com/problems/push-dominoes/submissions/

public class Solution {
    private int n;

    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        n = sb.length();

        int lastR = -1;
        for (int i = 0; i < n; ++i) {
            if (sb.charAt(i) == 'L') {
                if (lastR > -1) {
                    pushInBetween(lastR + 1, i - 1, sb);
                    lastR = -1;
                } else {
                    pushLeft(i - 1, sb);
                }
            }
            if (sb.charAt(i) == 'R') {
                if (lastR > -1) {
                    pushRight(lastR + 1, sb);
                }
                lastR = i;
            }
        }
        if (lastR > -1) {
            pushRight(lastR + 1, sb);
        }
        return sb.toString();
    }

    private void pushRight(int idx, StringBuilder sb) {
        while (idx < n && sb.charAt(idx) == '.') {
            sb.setCharAt(idx++, 'R');
        }
    }

    private void pushLeft(int idx, StringBuilder sb) {
        while (idx >= 0 && sb.charAt(idx) == '.') {
            sb.setCharAt(idx--, 'L');
        }
    }

    private void pushInBetween(int l, int r, StringBuilder sb) {
        while (l < r) {
            sb.setCharAt(l++, 'R');
            sb.setCharAt(r--, 'L');
        }
    }
}