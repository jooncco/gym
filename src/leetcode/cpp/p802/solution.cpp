// https://leetcode.com/problems/find-eventual-safe-states/
/***
 * DP
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


int n, cache[10010];
bool visited[10010];

class Solution {
public:
    vi eventualSafeNodes(vvi& graph) {
        n= graph.size();
        memset(cache, -1, sizeof(cache));
        vi ans;
        for (int i=0; i < n; ++i) {
            memset(visited, 0, sizeof(visited));
            if (isSafeNode(graph, i)) {
                ans.push_back(i);
            }
        }
        return ans;
    }

private:
    int isSafeNode(vvi& G, int cur) {
        if (G[cur].empty()) return 1;
        
        int &ret= cache[cur];
        if (ret > -1) return ret;
        if (visited[cur]) return ret= 0;
        visited[cur]= 1;
        for (int there : G[cur]) {
            if (isSafeNode(G, there) == 0) {
                return ret= 0;
            }
        }
        return ret= 1;
    }
};