// https://algospot.com/judge/problem/read/PALINDROMIZE
/***
 * String
 * Time: O(|s|)
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

string s, r;
int pm[100010];

void computePm(string& str) {
    memset(pm, 0, sizeof(pm));
    int n= str.length();
    int begin= 1, matched= 0;
    while (begin+matched <= n) {
        if (begin+matched < n && str[begin+matched] == str[matched]) {
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
}

void solve() {
    cin >> s;
    r= s; reverse(r.begin(), r.end());
    computePm(r);
    int n= s.length();
    int begin= 0, matched= 0;
    int maxOverlap= 1;
    while (begin+matched <= n) {
        if (begin+matched < n && s[begin+matched] == r[matched]) {
            ++matched;
            if (begin+matched == n) {
                maxOverlap= matched;
                break;
            }
        } else {
            if (matched == 0) ++begin;
            else {
                begin += matched-pm[matched-1];
                matched= pm[matched-1];
            }
        }
    }
    cout << 2*n-maxOverlap << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}