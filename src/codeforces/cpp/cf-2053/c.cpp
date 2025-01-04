// https://codeforces.com/contest/2053/problem/C
/***
 * Math
 * Time: O(log(n))
 * Space: O(1)
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

ll n, k;

void solve() {
    cin >> n >> k;
    ll avg= n+1, sum= 0, cnt= 1;
    while (n >= k) {
        if (n%2 == 1) sum += cnt;
        cnt <<= 1;
        n >>= 1;
    }
    cout << avg*sum/2 << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}