// https://leetcode.com/problems/grid-game/
/***
 * Prefix Sum
 * Time: O(2n)
 * Space: O(2n)
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

const ll INF = (ll)2e18 + 7;

class Solution {
public:
    ll gridGame(vvi& grid) {
        int n= grid[0].size();
        vvll prefSum(2, vll(n+2)), suffSum(2, vll(n+2));
        for (int j=0; j < 2; ++j) {
            for (int i=0; i < n; ++i) {
                prefSum[j][i+1]= prefSum[j][i]+grid[j][i];
                suffSum[j][n-i]= suffSum[j][n-i+1]+grid[j][n-i-1];
            }
        }
        ll mnSum= INF;
        for (int m=1; m <= n; ++m) {
            mnSum= min(mnSum, max(prefSum[1][m-1],suffSum[0][m+1]));
        }
        return mnSum;
    }
};