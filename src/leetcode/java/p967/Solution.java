package leetcode.java.p967;
// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> nums;

    public int[] numsSameConsecDiff(int n, int k) {
        nums = new ArrayList<>();
        for (int i = 1; i <= 9; ++i)
            construct(i, 1, n, k);
        return nums.stream().mapToInt(a -> a).toArray();
    }

    private void construct(int cur, int digits, int n, int k) {
        if (digits == n) {
            nums.add(cur);
            return;
        }

        int lsd = cur % 10;
        if (lsd + k < 10)
            construct(cur * 10 + lsd + k, digits + 1, n, k);
        if (lsd - k >= 0)
            construct(cur * 10 + lsd - k, digits + 1, n, k);
    }
}