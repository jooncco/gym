// https://algospot.com/judge/problem/read/GRADUATION
/**
 * Bitmask, DP
 * Time: O(m 2^(2n))
 * Space: O(m 2^n)
 * Solved: 2024. 12. 09. Mon
 */
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

const int INF= 987654321;

int n, k, m, l;
int pre[14], open[12];
int cache[12][1<<12];

int minSem(int sem, int taken) {
    if (bitcount(taken) >= k) return 0;
    if (sem == m) return INF;

    int &ret= cache[sem][taken];
    if (ret > -1) return ret;
    
    ret= INF;
    int canTake= open[sem] & ~taken; // skip taken
    for (int i=0; i < n; ++i) {
        if ((canTake & (1<<i))) {
            if ((pre[i]&taken) != pre[i]) {
                canTake &= ~(1<<i);
            }
        }
    }
    for (int take= canTake; take; take= canTake&(take-1)) { // for every subset
        if (bitcount(take) > l) continue;
        ret= min(ret, 1+minSem(sem+1, taken|take));
    }
    ret= min(ret, minSem(sem+1, taken));

    return ret;
}

void solve() {
    cin >> n >> k >> m >> l;
    for (int i=0; i < n; ++i) {
        int mask= 0, s, sbj;
        cin >> s;
        for (int j=0; j < s; ++j) {
            cin >> sbj;
            mask |= (1<<sbj);
        }
        pre[i]= mask;
    }
    for (int i=0; i < m; ++i) {
        int mask= 0, c, o;
        cin >> c;
        for (int j=0; j < c; ++j) {
            cin >> o;
            mask |= (1<<o);
        }
        open[i]= mask;
    }
    memset(cache, 0xFF, sizeof(cache));

    int ans= minSem(0, 0);
    cout << (ans < INF ? to_string(ans) : "IMPOSSIBLE") << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}