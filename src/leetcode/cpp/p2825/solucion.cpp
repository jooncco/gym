// https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/
#include <bits/stdc++.h>
using namespace std;

/**
 * String
 * Time: O(m+n)
 * Space: O(1)
 */
class Solution {
public:
    bool canMakeSubsequence(string str1, string str2) {
        int m= str1.length(), n= str2.length(), idx= 0;
        for (int i=0; i < m; ++i) {
            if (idx == n) break;
            if (str1[i] == str2[idx] || (str1[i]-'a'+1)%26 == str2[idx]-'a') ++idx;
        }
        return idx == n;
    }
};