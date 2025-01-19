// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/
/***
 * Monotone Stack, Prefix Sum
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
    ll minMaxSubarraySum(vi& nums, int k) {
        ll mnSum= subArraySum(nums, k, 1);
        ll mxSum= subArraySum(nums, k, 0);
        return mnSum+mxSum;
    }

private:
    ll subArraySum(vi& nums, int k, bool isMin) {
        int n= nums.size();
        if (isMin) {
            for (int i=0; i < n; ++i) {
                nums[i] *= -1;
            }
        }
        
        ll ret= 0, prefSum= 0;
        deque<int> D;
        for (int i=0; i < n; ++i) {
            // Remove back
            while (D.size() && nums[D.back()] <= nums[i]) {
                int b= D.back(); D.pop_back();
                if (D.size()) {
                    prefSum -= (b-D.back())*1ll*nums[b];
                }
            }
            if (D.size()) {
                prefSum += (i-D.back())*1ll*nums[i];
            }
            D.push_back(i);
            // Remove front (out of range)
            if (D.front() == i-k) {
                int f= D.front(); D.pop_front();
                if (D.size()) {
                    prefSum -= (D.front()-f)*1ll*nums[D.front()];
                }
            }
            ret += (D.front()-max(-1, i-k))*1ll*nums[D.front()] + prefSum;
        }
        if (isMin) {
            for (int i=0; i < n; ++i) {
                nums[i] *= -1;
            }
            ret *= -1;
        }
        return ret;
    }
};