// https://codeforces.com/contest/2062/problem/B
/***
 * Greedy
 * Time: O(n)
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

int n, a[500010];

void solve() {
    cin >> n;
    for (int i=0; i < n; ++i) {
        cin >> a[i];
    }
    bool yes= 1;
    for (int i=0; i < n; ++i) {
        if ((n-1-i)*2 >= a[i] || i*2 >= a[i]) {
            yes= 0;
            break;
        }
    }
    cout << (yes ? "YES\n" : "NO\n");
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}