// https://leetcode.com/problems/letter-tile-possibilities/
/***
 * Math, Combinatorics
 * Time: O(n1*n2*n3*..*nk) where nk is the frequency of each character
 * Space: O(n1*n2*n3*..*nk) where nk is the frequency of each character
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
    int numTilePossibilities(string tiles) {
        const int N= tiles.length();
        int f[8];
        f[0]= f[1]= 1;
        for (int i=2; i <= 7; ++i) {
            f[i]= f[i-1]*i;
        }
        vi cnt(26, 0);
        for (int i=0; i < N; ++i) {
            ++cnt[tiles[i]-'A'];
        }
        int ans= 0;
        auto dfs= [&](auto self, int total, vi& cnts, int idx) -> void {
            if (idx == 26) {
                if (total) {
                    int p= f[total];
                    for (int c : cnts) {
                        if (c) p /= f[c];
                    }
                    ans += p;
                }
                return;
            }

            for (int i=0; i <= cnt[idx]; ++i) {
                cnts.push_back(i);
                self(self, total+i, cnts, idx+1);
                cnts.pop_back();
            }
        };
        vi cnts;
        dfs(dfs, 0, cnts, 0);
        return ans;
    }
};