// https://algospot.com/judge/problem/read/BRACKETS2
/***
 * Stack
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

void solve() {
    string str;
    cin >> str;
    int n= str.length();
    bool yes= true;
    stack<char> s;
    for (int i=0; i < n; ++i) {
        if (str[i] == '(' || str[i] == '{' || str[i] == '[') s.push(str[i]);
        if (str[i] == ')') {
            if (s.empty() || s.top() != '(') {
                yes= false;
                break;
            } else s.pop();
        }
        if (str[i] == '}') {
            if (s.empty() || s.top() != '{') {
                yes= false;
                break;
            } else s.pop();
        }
        if (str[i] == ']') {
            if (s.empty() || s.top() != '[') {
                yes= false;
                break;
            } else s.pop();
        }
    }
    if (!s.empty()) yes= false;
    cout << (yes ? "YES" : "NO") << "\n";
}

int main() {
    FAST_IO;
    int t; cin >> t;
    while (t--) solve();
}