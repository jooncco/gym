// https://algospot.com/judge/problem/read/FENCE
/**
 * Monotone Stack
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

void solve() {
    int n;
    cin >> n;
    vector<int> h(n,0);
    for (int i=0; i < n; ++i) cin >> h[i];
    h.push_back(0);

    int ans= 0;
    stack<int> s;
    for (int i=0; i <= n; ++i) {
        while (!s.empty() && h[s.top()] >= h[i]) {
            int height= h[s.top()];
            s.pop();
            int width= s.empty() ? i : i-s.top()-1;
            ans= max(ans, height*width);
        }
        s.push(i);
    }
    cout << ans << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}