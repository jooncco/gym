// https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
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

class Solution {
public:
    bool areAlmostEqual(string s1, string s2) {
        int n= s1.length();
        vi diff;
        for (int i=0; i < n; ++i) {
            if (s1[i] != s2[i]) diff.push_back(i);
        }
        if (diff.empty()) return 1;
        if (diff.size() > 2) return 0;
        int a= diff[0], b= diff[1];
        return s1[a] == s2[b] && s1[b] == s2[a];
    }
};