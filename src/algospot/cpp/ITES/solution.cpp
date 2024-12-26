// https://algospot.com/judge/problem/read/ITES
/***
 * Two Pointers
 * Time: O(n)
 * Space: O(k)
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

unsigned next(unsigned cur) {
    return (cur * 214013u + 2531011u);
}

void solve() {
    int k, n;
    cin >> k >> n;
    unsigned A= 1983;
    int ans= 0, sum= 0;
    queue<int> q;
    for (int i=0; i < n; ++i) {
        int signal= (A%10000)+1;
        sum += signal;
        q.push(signal);
        while (!q.empty() && sum > k) {
            sum -= q.front();
            q.pop();
        }
        if (sum == k) ++ans;
        A= next(A);
    }
    cout << ans << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}