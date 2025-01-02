// https://algospot.com/judge/problem/read/NAMING
/***
 * String
 * Time: O(|n+m|)
 * Space: O(|n+m|)
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

string A, B;
int pm[400010];

void solve() {
    cin >> A >> B;
    string H= A+B;
    int n= H.length();
    memset(pm, 0, sizeof(pm));
    vector<int> ans(1, n); // trivial case
    int begin= 1, matched= 0;
    while (begin+matched <= n) {
        if (begin+matched < n && H[begin+matched] == H[matched]) {
            ++matched;
            pm[begin+matched-1]= matched;
        } else {
            if (matched == 0) ++begin;
            else {
                begin += matched-pm[matched-1];
                matched= pm[matched-1];
            }
        }
        if (begin+matched == n && matched) {
            ans.push_back(matched);
        }
    }
    cout << ans.back(); ans.pop_back();
    while (!ans.empty()) {
        cout << " " << ans.back(); ans.pop_back();
    }
}

int main() {
    FAST_IO;
    solve();
}