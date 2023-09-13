package leetcode.p135;
// https://leetcode.com/problems/candy/

/**
 * Greedy
 * | Time: O(n)
 * | Space: O(n)
 */
public class Solution {
    public int candy(int[] a) {
        int n= a.length;
        if (n == 1) return 1;
        
        int[] cnt= new int[n];
        if (a[0] <= a[1]) cnt[0]= 1;
        int i= 1, cur= 1;
        while (i < n) {
            if (a[i-1] == a[i]) {
                cnt[i++]= cur= 1;
            } else if (a[i-1] < a[i]) {
                cnt[i++]= ++cur;
            } else {
                int len= 1;
                while (i < n && a[i-1] > a[i]) {
                    ++len;
                    ++i;
                }
                for (int j=1; j <= len; ++j) {
                    cnt[i-j]= Math.max(cnt[i-j], j);
                }
                cur= 1;
            }
        }
        int ans= 0;
        for (int j=0; j < n; ++j) ans += cnt[j];
        return ans;
    }
}
