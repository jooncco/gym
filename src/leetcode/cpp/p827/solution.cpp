// https://leetcode.com/problems/making-a-large-island/
/***
 * DFS (Flood Fill)
 * Time: O(n^2)
 * Space: O(n^2)
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
using vb= vector<bool>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvb= vector<vb>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    int largestIsland(vvi& grid) {
        const int n= grid.size();
        const int dy[4]= {-1, 1, 0, 0}, dx[4]= {0, 0, -1, 1};
        
        vi island(1);
        vvi visited(n, vi(n));
        auto dfs= [&](auto self, int y, int x, int group) -> void {
            int ny, nx;
            for (int i=0; i < 4; ++i) {
                ny= y+dy[i]; nx= x+dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (grid[ny][nx] == 0) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx]= group;
                island[group]++;
                self(self, ny, nx, group);
            }
        };
        
        // Count sizes
        for (int i=0; i < n; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] && !visited[i][j]) {
                    int groupId= island.size();
                    island.push_back(1);
                    visited[i][j]= groupId;
                    dfs(dfs, i, j, groupId);
                }
            }
        }

        // Find connections
        int ans= 0;
        for (int y=0; y < n; ++y) {
            for (int x=0; x < n; ++x) {
                int ny, nx;
                unordered_set<int> groups;
                if (visited[y][x]) groups.insert(visited[y][x]);
                for (int i=0; i < 4; ++i) {
                    ny= y+dy[i]; nx= x+dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                    if (grid[ny][nx] == 0) continue;
                    if (visited[ny][nx]) {
                        groups.insert(visited[ny][nx]);
                    }
                }
                int sum= 0;
                if (grid[y][x] == 0) ++sum;
                for (int group : groups) {
                    sum += island[group];
                }
                ans= max(ans, sum);
            }
        }
        return ans;
    }
};