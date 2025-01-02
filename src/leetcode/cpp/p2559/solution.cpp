// https://leetcode.com/problems/count-vowel-strings-in-ranges/
/***
 * Prefix Sum
 * Time: O(n+q)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    bool isVowelString(string str) {
        return isVowel(str[0]) && isVowel(str[str.length()-1]);
    }

    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        int cnt[100010];
        memset(cnt, 0, sizeof(cnt));
        int n= words.size();
        for (int i=1; i <= n; ++i) {
            cnt[i]= cnt[i-1];
            if (isVowelString(words[i-1])) ++cnt[i];
        }
        vector<int> ret;
        for (vector<int>& query : queries) {
            ret.push_back(cnt[query[1]+1]-cnt[query[0]]);
        }
        return ret;
    }
};