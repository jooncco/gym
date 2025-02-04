// https://codeforces.com/contest/2044/problem/B
/***
 * String
 * Time: O(|s|)
 * Space: O(|s|)
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

const ll MOD = (ll)998244353;
const ll INF = (ll)2e18 + 7;

string a;

void solve() {
    cin >> a;
    ll n= a.length();
    auto flip= [&](char c) {
        if (c == 'p') return 'q';
        if (c == 'q') return 'p';
        return 'w';
    };
    for (int i=n-1; i >= 0; --i) {
        cout << flip(a[i]);
    }
    cout << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}