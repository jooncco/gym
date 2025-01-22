// https://leetcode.com/problems/map-of-highest-peak/
/***
 * BFS
 * Time: O(mn)
 * Space: O(mn)
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

const int dy[4]= {-1, 0, 0, 1}, dx[4]= {0, -1, 1, 0};

class Solution {
public:
    vvi highestPeak(vvi& isWater) {
        int m= isWater.size(), n= isWater[0].size();
        vvi h(m, vi(n, -1));
        queue<pii> Q;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (isWater[i][j]) {
                    Q.push({i,j});
                    h[i][j]= 0;
                }
            }
        }
        while (Q.size()) {
            auto [y,x]= Q.front(); Q.pop();
            int ny, nx;
            for (int i=0; i < 4; ++i) {
                ny= y+dy[i]; nx= x+dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if (h[ny][nx] > -1) continue;
                h[ny][nx]= h[y][x]+1;
                Q.push({ny,nx});
            }
        }
        return h;
    }
};