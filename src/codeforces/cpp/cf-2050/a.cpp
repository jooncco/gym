// https://codeforces.com/contest/2050/problem/A
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
 * Greedy
 * Time: O(n)
 * Space: O(n)
 */
void solve() {
    int n, m;
    cin >> n >> m;
    string words[60];
    for (int i=0; i < n; ++i) cin >> words[i];
    int x= 0, len= 0;
    for (int i=0; i < n; ++i) {
        if (len+words[i].length() > m) break;
        len += words[i].length();
        ++x;
    }
    cout << x << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}