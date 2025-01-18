// https://codeforces.com/contest/2056/problem/C
/***
 * Constructive Algorithms
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

int n;

void solve() {
    cin >> n;
    vi ans(n);
    iota(ans.begin(), ans.end(), 1);
    ans[0]= ans[1]= n;
    for (int i=0; i < n; ++i) {
        cout << ans[i] << " \n"[i == n-1];
    }
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}