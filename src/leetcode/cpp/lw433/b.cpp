// https://leetcode.com/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/
/***
 * Math, Combinatorics
 * Time: O(nk)
 * Space: O(nk)
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

const int MOD = 1e9 + 7;

inline int _mul(int a, int b) {
    ll ret = a * 1ll * b;
    ret %= MOD;
    return int(ret);
}

inline int _add(int a, int b) {
    ll ret = a + b;
    while (ret >= MOD) ret -= MOD;
    while (ret < 0) ret += MOD;
    return int(ret);
}

inline int _binPow(int x, int n) {
    int ret = 1;
    int d = x;
    while (n) {
        if (n & 1) {
            ret = _mul(ret, d);
        }
        d = _mul(d, d);
        n >>= 1;
    }
    return ret;
}

inline int _inv(int a) {
    return _binPow(a, MOD - 2);
}

inline int _div(int a, int b) {
    return _mul(a, _inv(b));
}

int C[100010][110];

class Solution {
public:
    int minMaxSums(vi& nums, int k) {
        int n= nums.size();
        preCalc(n, k);
        sort(nums.begin(), nums.end());
        int ans= 0;
        for (int i=0; i < n; ++i) {
            for (int j=1; j <= k; ++j) {
                // min
                int rCnt= n-1-i;
                if (rCnt >= j-1) {
                    ans= _add(ans, _mul(nums[i], C[rCnt][j-1]));
                }
                // max
                int lCnt= i;
                if (lCnt >= j-1) {
                    ans= _add(ans, _mul(nums[i], C[lCnt][j-1]));
                }
            }
        }
        return ans;
    }

private:
    void preCalc(int n, int k) {
        memset(C, 0, sizeof(C));
        C[0][0]= C[1][0]= C[1][1]= 1;
        for (int i=2; i <= n; ++i) {
            for (int j=0; j <= min(i, k); ++j) {
                if (j == 0 || i == j) C[i][j]= 1;
                else C[i][j]= _add(C[i-1][j-1],C[i-1][j]);
            }
        }
    }
};