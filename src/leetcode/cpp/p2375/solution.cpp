// https://leetcode.com/problems/construct-smallest-number-from-di-string/
/***
 * Constructive Algorithms, Greedy
 * Time: O(n^n)
 * Space: O(n^n)
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
    string smallestNumber(string pattern) {
        const int N= pattern.length();
        vb used(10, 0);
        vi ans, cur(N+1);
        auto dfs= [&](auto self, int idx) {
            if (ans.size()) return;
            if (idx == N+1) {
                ans= cur;
                return;
            }

            if (pattern[idx-1] == 'D') {
                for (int i=1; i < cur[idx-1]; ++i) {
                    if (used[i]) continue;
                    cur[idx]= i;
                    used[i]= 1;
                    self(self, idx+1);
                    used[i]= 0;
                    cur[idx]= -1;
                }
            } else {
                for (int i=cur[idx-1]+1; i < 10; ++i) {
                    if (used[i]) continue;
                    cur[idx]= i;
                    used[i]= 1;
                    self(self, idx+1);
                    used[i]= 0;
                    cur[idx]= -1;
                }
            }
        };
        for (int i=1; i < 10; ++i) {
            used[i]= 1;
            cur[0]= i;
            dfs(dfs, 1);
            cur[0]= -1;
            used[i]= 0;
        }
        string ret= "";
        for (int num : ans) {
            ret += (char)('0'+num);
        }
        return ret;
    }
};