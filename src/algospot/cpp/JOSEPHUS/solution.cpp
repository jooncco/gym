// https://algospot.com/judge/problem/read/JOSEPHUS
/**
 * Brute Force
 * Time: O(nk)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
typedef long long ll;
typedef pair<int,int> ii;
typedef list<int> li;
typedef list<ii> lii;
typedef deque<int> di;
typedef deque<ii> dii;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef vector<ii> vii;
typedef priority_queue<int, vi, less<int>> maxHeap;
typedef priority_queue<int, vi, greater<int>> minHeap;

int n, k;

void solve() {
    cin >> n >> k;
    li ppl;
    for (int i=1; i <= n; ++i) {
        ppl.push_back(i);
    }
    li::iterator it= ppl.begin();
    for (int i=0; i < n-2; ++i) {
        it= ppl.erase(it);
        if (it == ppl.end()) it= ppl.begin();
        for (int j=0; j < k-1; ++j) {
            ++it;
            if (it == ppl.end()) it= ppl.begin();
        }
    }
    cout << ppl.front() << " " << ppl.back() << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}