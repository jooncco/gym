// https://leetcode.com/problems/maximum-number-of-k-divisible-components/
/**
 * DFS
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int N, K;
    vector<int> V;
    vector<vector<int>> children;
    int ans;

    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
        N= n; K= k;
        V= values;
        children= vector<vector<int>>(N);
        
        // Construct tree
        vector<vector<int>> adj= vector<vector<int>>(N);
        for (auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        queue<int> q; q.push(0);
        vector<bool> visited(N,0);
        visited[0]= true;
        while (!q.empty()) {
            int here= q.front(); q.pop();
            for (int there : adj[here]) {
                if (visited[there]) continue;
                children[here].push_back(there);
                visited[there]= true;
                q.push(there);
            }
        }
        
        // Count subtrees with sum % k = 0
        ans= 0;
        dfs(0);
        return ans;
    }

    int dfs(int here) {
        int sum= V[here];
        for (int child : children[here]) {
            sum= (sum+dfs(child))%K;
        }
        if (sum%K == 0) ++ans;
        return sum;
    }
};