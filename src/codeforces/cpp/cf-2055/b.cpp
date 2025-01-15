// https://codeforces.com/contest/2055/problem/B
/***
 * Greedy, Math
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

const int INF = 2e9 + 7;

int n;
int a[200010], b[200010];

void solve() {
    cin >> n;
    for (int i=0; i < n; ++i) cin >> a[i];
    for (int i=0; i < n; ++i) cin >> b[i];
    int badCnt= 0, badIdx= -1;
    for (int i=0; i < n; ++i) {
        if (a[i] < b[i]) {
            badCnt++;
            badIdx= i;
        }
    }
    if (badCnt > 1) {
        cout << "NO\n";
    }
    else if (badCnt == 0) {
        cout << "YES\n";
    }
    else {
        int diff= b[badIdx]-a[badIdx];
        for (int i=0; i < n; ++i) {
            if (i != badIdx && a[i]-b[i] < diff) {
                cout << "NO\n";
                return;
            }
        }
        cout << "YES\n";
    }
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}