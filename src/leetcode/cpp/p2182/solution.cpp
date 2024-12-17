// https://leetcode.com/problems/construct-string-with-repeat-limit/
/**
 * Greedy
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<char> vc;

class Solution {
public:
    string ans;
    int cnt;
    queue<char> buf;

    void appendFromBuf(int lim) {
        while (!buf.empty()) {
            if (buf.front() == ans.back()) {
                if (cnt == lim) break;
                ++cnt;
            } else {
                cnt= 1;
            }
            ans.push_back(buf.front());
            buf.pop();
        }
    }

    string repeatLimitedString(string s, int lim) {
        int n= s.length();
        vc src(n);
        for (int i=0; i < n; ++i) src[i]= s[i];
        sort(src.begin(), src.end());

        ans.push_back(src[n-1]); src.pop_back();
        cnt= 1;
        for (int i=n-2; i >= 0; --i) {
            appendFromBuf(lim);
            if (src[i] == ans.back()) {
                if (cnt < lim) {
                    ans.push_back(src[i]);
                    ++cnt;
                } else {
                    buf.push(src[i]);
                }
            } else {
                ans.push_back(src[i]);
                cnt= 1;
            }
        }
        appendFromBuf(lim);
        return ans;
    }
};