package leetcode.java.p1441;
// https://leetcode.com/problems/build-an-array-with-stack-operations/

import java.util.*;

/**
 * Stack
 * | Time: O(|target|)
 * | Space: O(|target|)
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        final String pushStr = "Push", popStr = "Pop";
        List<String> ret = new ArrayList<>();
        int cur = 1;
        for (int num : target) {
            while (cur < num) {
                ret.add(pushStr);
                ret.add(popStr);
                ++cur;
            }
            ret.add(pushStr);
            ++cur;
        }
        return ret;
    }
}