// https://codeforces.com/contest/2053/problem/A
/***
 * Math
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
typedef long long ll;
typedef pair<int,int> ii;
typedef priority_queue<int, vector<int>, less<int>> maxHeap;
typedef priority_queue<int, vector<int>, greater<int>> minHeap;

const int INF= 987654321;

int a[200010];

void solve() {
    int n;
    cin >> n;
    for (int i=0; i < n; ++i) cin >> a[i];
    bool yes= false;
    for (int i=1; i < n; ++i) {
        int A= a[i], B= a[i-1];
        if (min(A,B)*2 > max(A,B)) {
            yes= true;
            break;
        }
    }
    cout << (yes ? "YES" : "NO") << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}