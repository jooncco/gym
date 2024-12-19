// https://algospot.com/judge/problem/read/CHRISTMAS
/**
 * Prefix Sum, DP
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
typedef long long ll;
typedef pair<int,int> ii;
typedef list<int> li;
typedef list<ii> lii;
typedef deque<int> di;
typedef deque<ii> dii;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<ii> vii;
typedef priority_queue<int, vi, less<int>> maxHeap;
typedef priority_queue<int, vi, greater<int>> minHeap;

const int MOD = 20091101;

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

void solve() {
    int N, K;
    cin >> N >> K;
    vi D(N+1, 0);
    for (int i=1; i <= N; ++i) cin >> D[i];
    vi pSum(N+1, 0);
    for (int i=1; i <= N; ++i) {
        pSum[i]= (pSum[i-1]+D[i])%K;
    }

    // # of possible orders
    vi cnt(K, 0);
    cnt[0]= 1;
    for (int i=1; i <= N; ++i) cnt[pSum[i]]++;
    ll ans1= 0;
    for (int i=0; i < K; ++i) {
        if (cnt[i]) {
            ans1= _add(ans1, _div(_mul(cnt[i], cnt[i]-1), 2));
        }
    }
    cout << ans1 << " ";

    // Max # of orders (DP)
    vi prev(K, -1);
    prev[0]= 0;
    vi cache(N+1, 0);
    for (int i=1; i <= N; ++i) {
        cache[i]= cache[i-1];
        int lastIdx= prev[pSum[i]];
        if (lastIdx > -1) {
            cache[i]= max(cache[i], cache[lastIdx]+1);
        }
        prev[pSum[i]]= i;
    }
    cout << cache[N] << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}