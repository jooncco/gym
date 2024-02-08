package leetcode.java.p168;
// https://leetcode.com/problems/excel-sheet-column-title/description/

/**
 * Math (Radix)
 * | Time: O (log(n))
 * | Space: O (1)
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        String ret = "";
        while (columnNumber > 0) {
            ret = ((char) ('A' + (columnNumber - 1) % 26)) + ret;
            columnNumber = (columnNumber - 1) / 26;
        }
        return ret;
    }
}