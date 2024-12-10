// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
/**
 * String, Prefix Sum
 * Time: O(26n)
 * Space: O(26n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;

class Solution {
public:
    int maximumLength(string s) {
        int cnt[26][51];
        memset(cnt, 0, sizeof(cnt));
        int n= s.length(), len= 1;
        for (int i=1; i < n; ++i) {
            if (s[i] == s[i-1]) ++len;
            else {
                cnt[s[i-1]-'a'][len]++;
                len= 1;
            }
        }
        cnt[s[n-1]-'a'][len]++;
        // suffix sum
        for (int i=0; i < 2; ++i) {
            for (int j=0; j < 26; ++j) {
                for (int k=50; k > 0; --k) {
                    cnt[j][k-1] += cnt[j][k];
                }
            }
        }
        int ans= -1;
        for (int c=0; c < 26; ++c) {
            for (int l=50; l > 0; --l) {
                if (cnt[c][l] >= 3) ans= max(ans, l);
            }
        }
        return ans;
    }
};