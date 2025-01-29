// https://leetcode.com/problems/redundant-connection/
/***
 * Union Find
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

class Solution {
public:
    vi findRedundantConnection(vvi& edges) {
        int n= edges.size();
        vi parent(n+1);
        for (int i=1; i <= n; ++i) {
            parent[i]= i;
        }
        auto find= [&](auto self, int a) {
            if (parent[a] == a) return a;
            return parent[a]= self(self, parent[a]);
        };
        auto unite= [&](int a, int b) {
            int rA= find(find, a), rB= find(find, b);
            if (rA == rB) return 0;
            parent[rA]= rB;
            return 1;
        };
        
        for (vi &edge : edges) {
            if (!unite(edge[0], edge[1])) {
                return {edge[0], edge[1]};
            }
        }
        return vi();
    }
};