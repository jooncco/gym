// https://leetcode.com/problems/paint-house-iv/
/***
 * DP
 * Time: O(9n)
 * Space: O(9n)
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

ll cache[100010][3][3];

class Solution {
public:
    ll minCost(int n, vvi& cost) {
        memset(cache, -1, sizeof(cache));
        ll ans= INF;
        for (int i=0; i < 3; ++i) {
            for (int j=0; j < 3; ++j) {
                if (i == j) continue;
                ans= min(ans, cost[0][i]+cost[n-1][j]+minCost(n, cost, 1, i, j));
            }
        }
        return ans;
    }

private:
    ll minCost(int n, vvi& cost, int idx, int lColor, int rColor) {
        if (idx == n/2) return 0;

        ll& ret= cache[idx][lColor][rColor];
        if (ret > -1) return ret;
        ret= INF;
        for (int i=0; i < 3; ++i) {
            if (i == lColor) continue;
            for (int j=0; j < 3; ++j) {
                if (j == rColor || i == j) continue;
                ret= min(ret, cost[idx][i]+cost[n-1-idx][j]+minCost(n, cost, idx+1, i, j));
            }
        }
        return ret;
    }
};