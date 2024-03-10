package leetcode.java.p349;
// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*

/**
 * Two Pointers
 * Time: O(nlogn + mlogm)
 * Space: O(n + m)
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int r = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (r >= nums2.length)
                break;
            if (i > 0 && nums1[i] == nums1[i - 1])
                continue;
            while (r < nums2.length && nums2[r] < nums1[i])
                r++;
            if (r < nums2.length && nums2[r] == nums1[i]) {
                list.add(nums1[i]);
                r++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}