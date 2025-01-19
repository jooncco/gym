package leetcode.java.lw-375. C;
// https://leetcode.com/contest/weekly-contest-375/problems/count-subarrays-where-max-element-appears-at-least-k-times/

/**
 * Two Pointers
 * | Time: O(n)
 * | Space: O(1)
 */
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length, mx = 0;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        long[] cnt = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            cnt[i] = cnt[i - 1];
            if (nums[i - 1] == mx)
                ++cnt[i];
        }
        if (cnt[n] < k)
            return 0;
        long ans = 0, prev = 0;
        int r = 1;
        for (int l = 1; l <= n; ++l) {
            if (nums[l - 1] != mx)
                continue;
            if (r < l)
                r = l;
            while (r <= n && cnt[r] - cnt[l - 1] < k)
                ++r;
            if (r > n)
                break;
            ans += (l - prev) * 1L * (n - r + 1);
            prev = l;
        }
        return ans;
    }
}