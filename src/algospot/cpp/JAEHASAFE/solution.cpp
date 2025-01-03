// https://algospot.com/judge/problem/read/JAEHASAFE
/***
 * String
 * Time: O(N|s|)
 * Space: O(|s|)
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

int N;
string cur;

vector<int> getPartialMatch(string& s) {
    int n= s.length();
    vector<int> pm(n,0);
    int begin= 1, matched= 0;
    while (begin+matched <= n) {
        if (begin+matched < n && s[begin+matched] == s[matched]) {
            ++matched;
            pm[begin+matched-1]= matched;
        } else {
            if (matched == 0) ++begin;
            else {
                begin += matched-pm[matched-1];
                matched= pm[matched-1];
            }
        }
    }
    return pm;
}

int nextCnt(string H, string N, bool clockwise) {
    if (clockwise) swap(H,N);
    H= H+H;
    int n= cur.length();
    vector<int> pm= getPartialMatch(N);
    int i, matched= 0;
    for (i=0; i < 2*n; ++i) {
        while (matched > 0 && H[i] != N[matched]) {
            matched= pm[matched-1];
        }
        if (H[i] == N[matched]) {
            ++matched;
            if (matched == n) break;
        }
    }
    return i-n+1;
}

void solve() {
    cin >> N >> cur;
    int ans= 0;
    for (int i=0; i < N; ++i) {
        string nxt; cin >> nxt;
        ans += nextCnt(cur, nxt, i%2 == 0);
        cur= nxt;
    }
    cout << ans << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}