// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/
/***
 * Siding Window
 * Time: O(n)
 * Space: O(1)
 */
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
using ll= long long;
using ld= long double;
using pii= pair<int,int>;
using pll= pair<ll,ll>;
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    int longestMonotonicSubarray(vi& nums) {
        int n= nums.size();
        int ans= 1, len= 0;
        for (int i=1; i < n; ++i) {
            if (nums[i] == nums[i-1]) {
                len= 0;
            }
            if (nums[i] > nums[i-1]) {
                if (len <= 0) len= 2;
                else ++len;
            }
            if (nums[i] < nums[i-1]) {
                if (len >= 0) len= -2;
                else --len;
            }
            ans= max(ans, abs(len));
        }
        return ans;
    }
};