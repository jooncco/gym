// https://leetcode.com/problems/count-servers-that-communicate/
/***
 * Array
 * Time: O(mn)
 * Space: O(m+n)
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
    int countServers(vvi& grid) {
        int m= grid.size(), n= grid[0].size();
        vi yCnt(m), xCnt(n);
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j]) {
                    ++yCnt[i];
                    ++xCnt[j];
                }
            }
        }
        int ans= 0;
        for (int i=0; i < m; ++i) {
            if (yCnt[i] > 1) ans += yCnt[i];
        }
        for (int i=0; i < n; ++i) {
            if (xCnt[i] > 1) ans += xCnt[i];
        }
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] && yCnt[i] > 1 && xCnt[j] > 1) ans -= 1;
            }
        }
        return ans;
    }
};