// https://codeforces.com/contest/2063/problem/A
/***
 * Math
 * Time: O(1)
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
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

int l,r;

void solve() {
    cin >> l >> r;
    if (l == r && l == 1) {
        cout << "1\n";
    } else {
        cout << r-l << "\n";
    }
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}