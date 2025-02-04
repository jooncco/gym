// https://codeforces.com/contest/2044/problem/D
/***
 * Constructive Algorithms
 * Time: O(n)
 * Space: O(200010)
 */
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
using ll= long long;
using ld= long double;
using pii= pair<int,int>;
using pll= pair<ll,ll>;
using vb= vector<bool>;
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvb= vector<vb>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

const ll MOD = (ll)998244353;
const ll INF = (ll)2e18 + 7;

ll n;
bool flag[200010];

void solve() {
    memset(flag, 0, sizeof(flag));
    cin >> n;
    ll a;
    int idx= 1;
    for (int i=0; i < n; ++i) {
        cin >> a;
        if (!flag[a]) {
            flag[a]= 1;
            cout << a << " \n"[i == n-1];
        } else {
            while (flag[idx]) {
                ++idx;
            }
            flag[idx]= 1;
            cout << idx++ << " \n"[i == n-1];
        }
    }
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}