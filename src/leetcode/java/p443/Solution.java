package leetcode.java.p443;
// https://leetcode.com/problems/string-compression/

/**
 * Array
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public int compress(char[] chars) {
        int n= chars.length, cnt= 1, idx= 0;
        char c= chars[0];
        for (int i=1; i <= n; ++i) {
            if (i < n && c == chars[i]) ++cnt;
            else {
                chars[idx++]= c;
                if (cnt > 1) {
                    String cntStr= cnt+"";
                    for (int j=0; j < cntStr.length(); ++j) {
                        chars[idx++]= cntStr.charAt(j);
                    }
                }
                if (i < n) {
                    c= chars[i];
                    cnt= 1;
                }
            }
        }
        return idx;
    }
}