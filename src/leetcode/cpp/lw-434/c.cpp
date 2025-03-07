// https://leetcode.com/problems/maximum-frequency-after-subarray-operation/
/***
 * Array, DP
 * Time: O(50n)
 * Space: O(n)
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
    int maxFrequency(vi& nums, int k) {
        int n= nums.size();
        int kCnt= count(nums.begin(), nums.end(), k);

        auto kadane= [&](int t) {
            int mxGap= 0, cur= 0;
            for (int num : nums) {
                if (num == t) {
                    ++cur;
                }
                if (num == k) {
                    --cur;
                }
                if (cur < 0) {
                    cur= 0;
                }
                mxGap= max(mxGap, cur);
            }
            return mxGap;
        };
        
        int ans= 0;
        for (int t=1; t <= 50; ++t) {
            ans= max(ans, kCnt+kadane(t));
        }
        return ans;
    }
};