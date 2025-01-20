// https://leetcode.com/problems/first-completely-painted-row-or-column/
/***
 * Array
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

int m, n;

class Solution {
public:
    int firstCompleteIndex(vi& arr, vvi& mat) {
        m= mat.size(); n= mat[0].size();
        vi y(m*n+1), x(m*n+1);
        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                y[mat[i][j]]= i;
                x[mat[i][j]]= j;
            }
        }
        vi rCnt(m), cCnt(n);
        for (int i=0; i < n*m; ++i) {
            rCnt[y[arr[i]]]++;
            cCnt[x[arr[i]]]++;
            if (rCnt[y[arr[i]]] == n || cCnt[x[arr[i]]] == m) return i;
        }
        return 0;
    }
};