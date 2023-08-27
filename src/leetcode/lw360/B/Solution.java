package leetcode.lw360.B;

public class Solution {
    public long minimumPossibleSum(int n, int target) {
        long a= Math.min(target/2, n), r= n-a;
        long ans= a*(a+1)/2;
        if (r > 0) ans += r*(2*target+r-1)/2;
        return ans;
    }
}