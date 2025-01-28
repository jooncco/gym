// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
/***
 * DFS (Flood Fill)
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

class Solution {
public:
    int findMaxFish(vvi& grid) {
        const int m= grid.size(), n= grid[0].size();
        const int dy[4]= {-1, 1, 0, 0}, dx[4]= {0, 0, -1, 1};
        
        bool visited[10][10];
        memset(visited, 0, sizeof(visited));
        auto dfs= [&](auto self, int y, int x) -> int {
            int ret= grid[y][x];
            int ny, nx;
            for (int i=0; i < 4; ++i) {
                ny= y+dy[i]; nx= x+dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                if (grid[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx]= 1;
                ret += self(self, ny, nx);
            }
            return ret;
        };

        int ans= 0;
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] && !visited[i][j]) {
                    visited[i][j]= 1;
                    ans= max(ans, dfs(dfs, i, j));
                }
            }
        }
        return ans;
    }
};