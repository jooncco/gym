package leetcode.p128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> sizes;

    public int longestConsecutive(int[] nums) {
        sizes = new HashMap<>();
        int ans= 1;
        for (final int num : nums) {
            if (sizes.get(num) != null) continue;

            int left= num-1, right= num+1;
            int leftSize= 0, rightSize= 0;
            if (sizes.get(left) != null) {
                leftSize= sizes.get(left);
            }
            if (sizes.get(right) != null) {
                rightSize= sizes.get(right);
            }

            int newSize;
            if (leftSize > 0 && rightSize > 0) {
                newSize= leftSize+rightSize+1;
                sizes.put(left, newSize);
                updateSizes(left, newSize);
                sizes.put(right, newSize);
                updateSizes(right, newSize);
            } else if (leftSize > 0) {
                newSize= leftSize+1;
                sizes.put(left, newSize);
                updateSizes(left, newSize);
            } else if (rightSize > 0) {
                newSize= rightSize+1;
                sizes.put(right, newSize);
                updateSizes(right, newSize);
            } else {
                newSize= 1;
            }
            sizes.put(num, newSize);
            ans= Math.max(ans, newSize);
        }
        return ans;
    }

    private void updateSizes(final int idx, final int newSize) {
        int l= idx-1, r= idx+1;
        while (sizes.get(l) != null) {
            sizes.put(l--, newSize);
        }
        while (sizes.get(r) != null) {
            sizes.put(r++, newSize);
        }
    }
}