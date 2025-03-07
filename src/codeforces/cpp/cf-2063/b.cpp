// https://codeforces.com/contest/2063/problem/B
/***
 * Greedy
 * Time: O(n log(n))
 * Space: O(n)
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

ll n, l, r;

void solve() {
    cin >> n >> l >> r;
    vll a(n+1);
    for (int i=1; i <= n; ++i) {
        cin >> a[i];
    }
    vll L;
    for (int i=1; i <= r; ++i) {
        L.push_back(a[i]);
    }
    sort(L.begin(), L.end());
    ll lSum= 0;
    for (int i=0; i < r-l+1; ++i) {
        lSum += L[i];
    }
    vll R;
    for (int i=l; i <= n; ++i) {
        R.push_back(a[i]);
    }
    sort(R.begin(), R.end());
    ll rSum= 0;
    for (int i=0; i < r-l+1; ++i) {
        rSum += R[i];
    }
    cout << min(lSum, rSum) << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}