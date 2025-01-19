// https://leetcode.com/contest/weekly-contest-432/problems/maximum-amount-of-money-robot-can-earn/
/***
 * DP
 * Time: O(nm)
 * Space: O(3nm)
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

const int INF= 987654321;

int n, m;
int cache[500][500][3];
int dy[2]= {0,1}, dx[2]= {1,0};

class Solution {
public:
    int maximumAmount(vvi& coins) {
        n= coins.size(); m= coins[0].size();
        for (int i=0; i < n; ++i) {
            for (int j=0; j < m; ++j) {
                for (int k=0; k < 3; ++k) {
                    cache[i][j][k]= -INF;
                }
            }
        }
        cache[0][0][2]= coins[0][0];
        cache[0][0][1]= 0;
        vector<vector<bool>> visited(n, vector<bool>(m));
        
        queue<pii> q;
        q.push({0,0});
        visited[0][0]= true;
        while (!q.empty()) {
            auto [y, x]= q.front(); q.pop();
            int ny, nx;
            for (int i=0; i < 2; ++i) {
                ny= y+dy[i]; nx= x+dx[i];
                if (ny >= n || nx >= m) continue;
                cache[ny][nx][2]= max(cache[ny][nx][2], cache[y][x][2]+coins[ny][nx]);
                cache[ny][nx][1]= max(cache[ny][nx][1], max(cache[y][x][2], cache[y][x][1]+coins[ny][nx]));
                cache[ny][nx][0]= max(cache[ny][nx][0], max(cache[y][x][1], cache[y][x][0]+coins[ny][nx]));
                if (!visited[ny][nx]) {
                    q.push({ny,nx});
                    visited[ny][nx]= true;
                }
            }
        }
        return max(cache[n-1][m-1][0], max(cache[n-1][m-1][1], cache[n-1][m-1][2]));
    }
};