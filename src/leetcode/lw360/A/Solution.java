package leetcode.lw360.A;

public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int loc= 0, wild= 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') ++loc;
            if (c == 'R') --loc;
            if (c == '_') ++wild;
        }
        return Math.max(Math.abs(loc-wild), Math.abs(loc+wild));
    }
}