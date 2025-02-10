// https://codeforces.com/contest/2044/problem/E
/***
 * Math
 * Time: O(1/log(k))
 * Space: O(1)
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

ll k, l1, r1, l2, r2;

void solve() {
    cin >> k >> l1 >> r1 >> l2 >> r2;
    ll cnt= 0;
    for (ll p=1; p <= r2; p *= k) {
        ll R= min(r1, r2/p);
        ll L= max(l1, (l2+p-1)/p);
        cnt += max(0ll, R-L+1);
    }
    cout << cnt << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}