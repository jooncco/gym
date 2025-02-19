// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
/***
 * Constructive Algorithms, Greedy
 * Time: O(3^n)
 * Space: O(3^n)
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
    string getHappyString(int n, int k) {
        const char chars[3]= {'a', 'b', 'c'};
        int cnt= 0;
        string ans= "";
        auto dfs= [&](auto self, string cur, int idx) {
            if (ans.length()) return;
            if (idx == n) {
                ++cnt;
                if (cnt == k) {
                    ans= cur;
                }
                return;
            }
            
            for (char c : chars) {
                if (cur.length() && cur[idx-1] == c) continue;
                self(self, cur+c, idx+1);
            }
        };
        dfs(dfs, "", 0);
        return ans;
    }
};