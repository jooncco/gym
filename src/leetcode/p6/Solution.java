package leetcode.p6;
// https://leetcode.com/problems/zigzag-conversion/

public class Solution {
    private static final int UP= 0, DOWN= 1;

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n= s.length();
        int[] indices= new int[n];
        int idx= 0, direction= 0; // 0: down, 1: up
        for (int i=0; i < n; ++i) {
            indices[i]= idx;
            if (direction == UP) {
                if (idx == 0) {
                    ++idx;
                    direction= DOWN;
                }
                else --idx;
            }
            else { // DOWN
                if (idx == numRows-1) {
                    --idx;
                    direction= UP;
                }
                else ++idx;
            }
        }
        StringBuilder sb= new StringBuilder();
        for (int i=0; i < numRows; ++i) {
            for (int j=0; j < n; ++j) {
                if (indices[j] == i) sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}