#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
using ll= long long;
using ld= long double;
using pii= pair<int,int>;
using pll= pair<ll,ll>;
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

const ll MOD = (ll)998244353;
const ll INF = (ll)2e18 + 7;

int n;
int o[200010];
vvi adj;

void solve() {
    cin >> n;
    memset(o, 0, sizeof(o));
    adj= vvi(n+1);
    int a, b;
    for (int i=0; i < n-1; ++i) {
        cin >> a >> b;
        ++o[a]; ++o[b];
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    int ans= 0;
    for (int i=0; i < 2; ++i) {
        int maxV= -1, maxO= -1;
        for (int j=1; j <= n; ++j) {
            if (maxO < o[j]) {
                maxV= j;
                maxO= o[j];
            }
        }
        o[maxV]= 0;
        for (int there : adj[maxV]) {
            o[there]--;
        }
        ans += maxO;
    }
    cout << ans-1 << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}