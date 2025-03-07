// https://leetcode.com/problems/count-partitions-with-even-sum-difference/
/***
 * Prefix Sum
 * Time: O(n)
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
    int countPartitions(vi& nums) {
        int n= nums.size();
        vi pSum(n+1);
        pSum[1]= nums[0];
        for (int i=1; i <= n; ++i) {
            pSum[i]= pSum[i-1]+nums[i-1];
        }
        int ans= 0;
        for (int i=1; i < n; ++i) {
            if (abs(pSum[i]-(pSum[n]-pSum[i]))%2 == 0) {
                ++ans;
            }
        }
        return ans;
    }
};