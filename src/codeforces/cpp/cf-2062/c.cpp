// https://codeforces.com/contest/2062/problem/C
/***
 * Brute Force
 * Time: O(n^2)
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

ll n;

void solve() {
    cin >> n;
    vll a(n);
    ll ans= 0;
    for (int i=0; i < n; ++i) {
        cin >> a[i];
        ans += a[i];
    }
    if (n == 1) {
        return cout << ans << "\n", void();
    }

    vll b;
    for (int i=1; i < n; ++i) {
        b.push_back(a[i]-a[i-1]);
    }
    while (b.size() > 1) {
        ll sum= b[0];
        vll nextB;
        for (int i=1; i < b.size(); ++i) {
            sum += b[i];
            nextB.push_back(b[i]-b[i-1]);
        }
        b= nextB;
        ans= max(ans, abs(sum));
    }
    ans= max(ans, abs(b[0]));
    cout << ans << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}