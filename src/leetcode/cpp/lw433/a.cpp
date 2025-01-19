// https://leetcode.com/problems/sum-of-variable-length-subarrays/
/**
 * Array
 * Time:O(n^2)
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

const ll MOD = (ll)998244353;
const ll INF = (ll)2e18 + 7;

class Solution {
public:
    int subarraySum(vi& nums) {
        int n= nums.size();
        int ans= 0;
        for (int i=0; i < n; ++i) {
            int start= max(0, i-nums[i]);
            for (int j=start; j <= i; ++j) ans += nums[j];
        }
        return ans;
    }
};