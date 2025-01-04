// https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
/***
 * Prefix Sum
 * Time: O(26^2*n)
 * Space: O(26n)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int n= s.length();
        vector<vector<int>> pSum(26, vector<int>(n,0));
        for (int i=0; i < n; ++i) {
            pSum[s[i]-'a'][i]++;
        }
        for (int i=0; i < 26; ++i) {
            for (int j=1; j < n; ++j) {
                pSum[i][j] += pSum[i][j-1];
            }
        }
        
        int ans= 0;
        for (int a= 0; a < 26; ++a) {
            for (int m=0; m < 26; ++m) {
                for (int i=1; i < n-1; ++i) {
                    if (s[i]-'a' == m) {
                        if (pSum[a][i-1] && pSum[a][n-1]-pSum[a][i] > 0) {
                            ++ans;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
};