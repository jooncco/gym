package leetcode.java.lw-357. A;
// https://leetcode.com/contest/weekly-contest-357/problems/faulty-keyboard/

/**
 * Implementation (String)
 * | Time: O (n^n)
 * | Space: O (n)
 */
public class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i')
                sb.reverse();
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
