// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
/***
 * DP
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
using vb= vector<bool>;
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvb= vector<vb>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    int maxAbsoluteSum(vi& nums) {
        auto kadane= [&](vi& nums, bool isNeg) {
            int ret= 0, sum= 0;
            for (int num : nums) {
                if (isNeg) num *= -1;
                if (sum < 0) sum= 0;
                sum += num;
                ret= max(ret, sum);
            }
            return ret;
        };
        return max(kadane(nums, 0), kadane(nums, 1));
    }
};