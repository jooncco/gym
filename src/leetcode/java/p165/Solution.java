package leetcode.java.p165;
// https://leetcode.com/problems/compare-version-numbers/

/**
 * String
 * | Time: O(m+n)
 * | Space: O(m+n)
 */
public class Solution {
    public int compareVersion(String v1, String v2) {
        String[] svs1 = v1.split("\\.");
        String[] svs2 = v2.split("\\.");
        for (int i = 0; i < Math.max(svs1.length, svs2.length); ++i) {
            int sv1 = i >= svs1.length
                    ? 0
                    : Integer.parseInt(svs1[i]);
            int sv2 = i >= svs2.length
                    ? 0
                    : Integer.parseInt(svs2[i]);
            if (sv1 == sv2)
                continue;
            return Integer.compare(sv1, sv2);
        }
        return 0;
    }
}