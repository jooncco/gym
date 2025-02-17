// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
/***
 * Constructive Algorithms, Greedy
 * Time: O(n^N) = O(n^n)
 * Space: O(n^N) = O(n^n)
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

class Solution {
public:
    vi constructDistancedSequence(int n) {
        const int N= (n-1)*2+1;
        vb used(n+1, 0);
        vi ret, cur(N, -1);
        
        auto dfs= [&](auto self, int idx) {
            if (ret.size()) return;
            if (idx == N) {
                ret= cur;
                return;
            }
            if (cur[idx] != -1) {
                self(self, idx+1);
                return;
            }
            
            for (int j=n; j > 1; --j) {
                if (used[j] || idx+j >= N || cur[idx+j] != -1) continue;
                used[j]= 1;
                cur[idx]= cur[idx+j]= j;
                self(self, idx+1);
                cur[idx]= cur[idx+j]= -1;
                used[j]= 0;
            }
            if (!used[1]) {
                used[1]= 1;
                cur[idx]= 1;
                self(self, idx+1);
                cur[idx]= -1;
                used[1]= 0;
            }
        };
        dfs(dfs, 0);
        
        return ret;
    }
};