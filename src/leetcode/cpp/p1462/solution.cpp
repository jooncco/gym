// https://leetcode.com/problems/course-schedule-iv/
/***
 * DP
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
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    vb checkIfPrerequisite(int n, vvi& prerequisites, vvi& queries) {
        vvi adj(n, vi());
        for (auto &edge : prerequisites) {
            adj[edge[0]].push_back(edge[1]);
        }
        
        int cache[100][100];
        memset(cache, -1, sizeof(cache));
        auto dfs= [&](auto self, int a, int b) {
            if (a == b) return 1;

            int &ret= cache[a][b];
            if (ret > -1) return ret;
            ret= 0;
            for (int there : adj[a]) {
                if (self(self, there, b)) {
                    return ret= 1;
                }
            }
            return ret;
        };
        
        vb ret;
        for (vi &query : queries) {
            ret.push_back(dfs(dfs, query[0], query[1]));
        }
        return ret;
    }
};