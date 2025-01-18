// https://codeforces.com/contest/2056/problem/B
/***
 * Constructive Algorithms
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

const int INF= 987654321;

int n;

void solve() {
    cin >> n;
    vector<string> g(n);
    for (int i=0; i < n; ++i) {
        cin >> g[i];
    }
    vi perm(n, 0);
    for (int i=1; i <= n; ++i) {
        int oneCnt= 0;
        for (int j=i; j < n; ++j) {
            if (g[i-1][j] == '1') oneCnt++;
        }
        int cnt= 0;
        for (int j=n-1; j >= 0; --j) {
            if (!perm[j]) ++cnt;
            if (cnt > oneCnt) {
                perm[j]= i;
                break;
            }
        }
    }
    for (int i=0; i < n; ++i) {
        if (i > 0) cout << " ";
        cout << perm[i];
    }
    cout << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}