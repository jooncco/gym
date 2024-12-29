// https://codeforces.com/contest/2050/problem/B
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
typedef long long ll;
typedef pair<int,int> ii;
typedef deque<int> di;
typedef deque<ii> dii;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<ii> vii;
typedef priority_queue<int, vi, less<int>> maxHeap;
typedef priority_queue<int, vi, greater<int>> minHeap;

/**
 * Math
 * Time: O(n)
 * Space: O(n)
 */
void solve() {
    int n; cin >> n;
    int a[n];
    for (int i=0; i < n; ++i) cin >> a[i];
    ll evenSum= 0, oddSum= 0;
    for (int i=0; i < n; ++i) {
        if (i%2 == 0) evenSum += a[i];
        else oddSum += a[i];
    }
    int evenCnt= n%2 == 0 ? n/2 : n/2+1, oddCnt= n/2;
    bool yes= 1;
    if (evenSum%evenCnt != 0) yes= 0;
    if (oddSum%oddCnt != 0) yes= 0;
    if (evenSum/evenCnt != oddSum/oddCnt) yes= 0;
    cout << (yes ? "YES" : "NO") << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}