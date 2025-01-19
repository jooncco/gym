// https://codeforces.com/contest/2056/problem/A
/***
 * Math, Geomerty
 * Time: O(n)
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

const int INF= 987654321;

int n, m;
int x, y;

void solve() {
    cin >> n >> m;
    int peri= m*4;
    for (int i=0; i < n; ++i) {
        cin >> x >> y;
        if (i == 0) continue;
        peri += 4*m - 2*(m-x) - 2*(m-y);
    }
    cout << peri << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}