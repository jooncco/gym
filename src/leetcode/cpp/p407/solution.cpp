// https://leetcode.com/problems/trapping-rain-water-ii/
/***
 * Priority Queue, BFS
 * Time: O(nm log(nm))
 * Space: O(nm)
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

const int dy[4]= {-1, 1, 0, 0}, dx[4]= {0, 0, -1, 1};

int n, m;
bool visited[210][210];

struct Comparator {
    bool operator()(const vi& a, const vi& b) {
        return a[0] > b[0];
    }
};

class Solution {
public:
    int trapRainWater(vvi& H) {
        n= H.size(); m= H[0].size();
        memset(visited, 0, sizeof(visited));
        
        priority_queue<vi, vvi, Comparator> pq;
        for (int i=0; i < n; ++i) {
            for (int j=0; j < m; ++j) {
                if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                    visited[i][j]= 1;
                    pq.push({H[i][j], i, j});
                }
            }
        }
        int ans= 0;
        while (pq.size()) {
            vi cur= pq.top(); pq.pop();
            int h= cur[0], y= cur[1], x= cur[2];
            int ny, nx;
            for (int i=0; i < 4; ++i) {
                ny= y+dy[i]; nx= x+dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx]) continue;
                
                if (h > H[ny][nx]) {
                    ans += h-H[ny][nx];
                    pq.push({h, ny, nx});
                } else {
                    pq.push({H[ny][nx], ny, nx});
                }
                visited[ny][nx]= 1;
            }
        }
        return ans;
    }
};