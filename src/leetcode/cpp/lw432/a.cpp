// https://leetcode.com/contest/weekly-contest-432/problems/zigzag-grid-traversal-with-skip/
/***
 * Array
 * Time: O(nm)
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
using vpll= vector<pll>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    vector<int> zigzagTraversal(vector<vector<int>>& grid) {
        int n= grid.size(), m= grid[0].size();
        vector<int> ret;
        bool alt= 1;
        for (int i=0; i < n; ++i) {
            if (i%2 == 0) {
                for (int j=0; j < m; ++j) {
                    if (alt) ret.push_back(grid[i][j]);
                    alt ^= 1;
                }
            } else {
                for (int j=m-1; j >= 0; --j) {
                    if (alt) ret.push_back(grid[i][j]);
                    alt ^= 1;
                }
            }
        }
        return ret;
    }
};