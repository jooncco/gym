package leetcode.java.p658;
// https://leetcode.com/problems/find-k-closest-elements/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int n;

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        n = arr.length;
        int idx = findClosestIdx(arr, x);

        List<Integer> ans = new LinkedList<>();
        ans.add(arr[idx]);
        --k;
        int l = idx - 1, r = idx + 1;
        while (k-- > 0) {
            if (l < 0)
                ans.add(arr[r++]);
            else if (r >= n)
                ans.add(0, arr[l--]);
            else if (x - arr[l] > arr[r] - x)
                ans.add(arr[r++]);
            else
                ans.add(0, arr[l--]);
        }
        return ans;
    }

    private int findClosestIdx(final int[] arr, int target) {
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}
