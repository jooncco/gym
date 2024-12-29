// https://codeforces.com/contest/2042/problem/A
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
typedef long long ll;
typedef pair<int,int> ii;
typedef deque<int> di;
typedef deque<ii> dii;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<ii> vii;
typedef priority_queue<int, vi, less<int>> maxHeap;
typedef priority_queue<int, vi, greater<int>> minHeap;

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

/**
 * Greedy
 * Time: O(n log(n))
 * Space: O(n)
 */
int n, k;

void solve() {
    cin >> n >> k;
    int a[n];
    for (int i=0; i < n; ++i) cin >> a[i];
    sort(a, a+n, greater<int>());
    int ans= 1e9, sum= 0;
    for (int i=0; i < n; ++i) {
        sum += a[i];
        if (sum <= k) {
            ans= min(ans, k-sum);
        }
    }
    cout << ans << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}