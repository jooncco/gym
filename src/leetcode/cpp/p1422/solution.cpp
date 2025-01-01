// https://leetcode.com/problems/maximum-score-after-splitting-a-string/
/***
 * Prefix Sum
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxScore(string s) {
        int n= s.length();
        int l[510], r[510];
        memset(l, 0, sizeof(l));
        for (int i=1; i <= n; ++i) {
            l[i]= l[i-1];
            if (s[i-1] == '0') ++l[i];
        }
        memset(r, 0, sizeof(r));
        for (int i=n; i >= 1; --i) {
            r[i]= r[i+1];
            if (s[i-1] == '1') ++r[i];
        }
        int ans= 0;
        for (int i=1; i < n; ++i) {
            ans= max(ans, l[i]+r[i+1]);
        }
        return ans;
    }
};