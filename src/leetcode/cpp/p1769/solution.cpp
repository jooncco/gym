// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
/***
 * Prefix Sum
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
using ll= long long;
using ld= long double;
using pii= pair<int,int>;
using pll= pair<ll,ll>;
using vi= vector<int>;
using vll= vector<ll>;
using vpll= vector<pll>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

const ll MOD = (ll)998244353;
const ll INF = (ll)2e18 + 7;

class Solution {
public:
    vector<int> minOperations(string boxes) {
        int n= boxes.length();
        vector<int> pSum(n+2);
        pSum[1]= boxes[0] == '1';
        for (int i=2; i <= n; ++i) pSum[i]= pSum[i-1] + (boxes[i-1] == '1');
        vector<int> sSum(n+2);
        sSum[n]= boxes[n-1] == '1';
        for (int i=n-1; i >= 1; --i) sSum[i]= sSum[i+1] + (boxes[i-1] == '1');
        vector<int> ans;
        int ops= 0;
        for (int i=1; i < n; ++i) {
            if (boxes[i] == '1') ops += i;
        }
        ans.push_back(ops);
        for (int i=1; i < n; ++i) {
            ans.push_back(ans[i-1] + pSum[i] - sSum[i+1]);
        }
        return ans;
    }
};