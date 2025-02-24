// https://leetcode.com/problems/most-profitable-path-in-a-tree/
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
using ll= long long;
using ld= long double;
using pii= pair<int,int>;
using pll= pair<ll,ll>;
using vb= vector<bool>;
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvb= vector<vb>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

const int INF= 2e9+7;

class Solution {
public:
    int mostProfitablePath(vvi& edges, int bob, vi& amount) {
        const int N= edges.size()+1;
        // Tree
        vvi adj(N, vi());
        for (vi& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        vi parent(N, -1);
        auto dfs= [&](auto self, int here) -> void {
            for (int there : adj[here]) {
                if (parent[here] != there) {
                    parent[there]= here;
                    self(self, there);
                }
            }
        };
        dfs(dfs, 0);
        
        // Simulate Bob
        int depth= -1;
        queue<int> q;
        q.push(0);
        while (q.size()) {
            ++depth;
            int sz= q.size();
            for (int i=0; i < sz; ++i) {
                int here= q.front(); q.pop();
                if (here == bob) {
                    q= {};
                    break;
                }
                for (int there : adj[here]) {
                    if (there != parent[here]) {
                        q.push(there);
                    }
                }
            }
        }
        for (int i=0; i < (depth+1)/2; ++i) {
            amount[bob]= 0;
            bob= parent[bob];
        }
        if (depth%2 == 0) {
            amount[bob] /= 2;
        }

        // Simulate Alice
        int ans= -INF;
        queue<pii> Q;
        Q.push({0,amount[0]});
        while (Q.size()) {
            auto [here, amt]= Q.front(); Q.pop();
            bool isLeaf= 1;
            for (int there : adj[here]) {
                if (there != parent[here]) {
                    Q.push({there, amt+amount[there]});
                    isLeaf= 0;
                }
            }
            if (isLeaf) {
                ans= max(ans, amt);
            }
        }
        return ans;
    }
};