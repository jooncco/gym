// https://leetcode.com/problems/longest-palindromic-subsequence-after-at-most-k-operations/
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
    int longestPalindromicSubsequence(string s, int k) {
        const int N= s.length();
        int cache[210][210][210];
        memset(cache, -1, sizeof(cache));
        auto getDistance= [&](auto self, char a, char b) -> int {
            if (a < b) return self(self, b, a);
            int _a= a-'a', _b= b-'a';
            return min(a-b, b+26-a);
        };
        auto dp= [&](auto self, int l, int r, int _k) -> int {
            if (l == r || s[l] == s[r]) return 1;
            if (l > r) return 0;
            
            int& ret= cache[l][r][_k];
            if (ret > -1) return ret;
            
            ret= 0;
            for (int i=l; i <= r; ++i) {
                for (int j=i; j <= r; ++j) {
                    int d= getDistance(getDistance, s[i], s[j]);
                    if (d <= _k) {
                        ret= max(ret, 2+self(self, l+1, r-1, _k-d));
                    } else {
                        ret= max(ret, self(self, l+1, r-1, _k));
                    }
                }
            }
            cout << "dp: (" << l << "," << r << "), ret: " << ret << "\n";
            return ret;
        };
        return dp(dp, 0, N-1, k);
    }
};