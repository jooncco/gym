// https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/
/**
 * DFS, DP
 * Time: O(n+m)
 * Space: O(n+m)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> depth;
    vector<int> d;

    int minimumDiameterAfterMerge(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        // Construct trees
        int n= edges1.size()+1, m= edges2.size()+1;
        vector<vector<int>> adj1(n), adj2(m);
        for (vector<int>& edge : edges1) {
            adj1[edge[0]].push_back(edge[1]);
            adj1[edge[1]].push_back(edge[0]);
        }
        for (vector<int>& edge : edges2) {
            adj2[edge[0]].push_back(edge[1]);
            adj2[edge[1]].push_back(edge[0]);
        }
        // Compute diameters
        d= vector<int>(2,0);
        depth.push_back(vector<int>(n, -1));
        dfs(0, adj1, -1, 0);
        depth.push_back(vector<int>(m, -1));
        dfs(1, adj2, -1, 0);
        if (d[0] < d[1]) swap(d[0], d[1]);
        return max(d[0], (d[0]+1)/2 + (d[1]+1)/2 + 1);
    }

    void dfs(int treeIdx, vector<vector<int>>& adj, int parent, int here) {
        vector<int> depths;
        for (int there : adj[here]) {
            if (there == parent) continue;
            depths.push_back(getDepth(treeIdx, adj, here, there));
            dfs(treeIdx, adj, here, there);
        }
        sort(depths.begin(), depths.end(), greater<int>());
        if (depths.size() == 1) d[treeIdx]= max(d[treeIdx], depths[0]+1);
        if (depths.size() > 1) d[treeIdx]= max(d[treeIdx], depths[0]+depths[1]+2);
    }
    
    int getDepth(int treeIdx, vector<vector<int>>& adj, int parent, int here) {
        int &ret= depth[treeIdx][here];
        if (ret > -1) return ret;

        ret= 0;
        for (int there : adj[here]) {
            if (there == parent) continue;
            ret= max(ret, getDepth(treeIdx, adj, here, there)+1);
        }
        return ret;
    }
};