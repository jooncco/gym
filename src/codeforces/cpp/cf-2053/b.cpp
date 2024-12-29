// https://codeforces.com/contest/2053/problem/B
/***
 * Prefix Sum
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

int n;
int l[400010], r[400010];
int c[400010], pSum[400010];

void solve() {
    cin >> n;
    for (int i=1; i <= 2*n; ++i) c[i]= 0;
    for (int i=0; i < n; ++i) {
        cin >> l[i] >> r[i];
    }
    for (int i=0; i < n; ++i) {
        if (l[i] == r[i]) c[l[i]]++;
    }
    for (int i=1; i <= 2*n; ++i) {
        pSum[i]= pSum[i-1] + (c[i] > 0);
    }
    for (int i=0; i < n; ++i) {
        cout << (l[i] == r[i] 
            ? (c[l[i]] == 1) 
            : (pSum[r[i]]-pSum[l[i]-1] < r[i]-l[i]+1));
    }
    cout << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}