// https://leetcode.com/problems/string-matching-in-an-array/
/***
 * String
 * Time: O(n^3)
 * Space: O(n)
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
using vi= vector<int>;
using vll= vector<ll>;
using vpll= vector<pll>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    vector<string> stringMatching(vector<string>& words) {
        int n= words.size();
        vector<string> ret;
        for (int i=0; i < n; ++i) {
            vector<int> pm= _getPartialMatch(words[i]);
            for (int j=0; j < n; ++j) {
                if (i == j) continue;
                if (_find(words[j], words[i], pm)) {
                    ret.push_back(words[i]);
                    break;
                }
            }
        }
        return ret;
    }

private:
    vector<int> _getPartialMatch(string N) {
        int n= N.length();
        vector<int> pm(n);
        int begin= 1, matched= 0;
        while (begin+matched <= n) {
            if (begin+matched < n && N[begin+matched] == N[matched]) {
                ++matched;
                pm[begin+matched-1]= matched;
            } else {
                if (matched == 0) {
                    ++begin;
                } else {
                    begin += matched-pm[matched-1];
                    matched= pm[matched-1];
                }
            }
        }
        return pm;
    }

    bool _find(string H, string N, vector<int>& pm) {
        int n= H.length(), m= N.length();
        int matched= 0;
        for (int i=0; i < n; ++i) {
            while (matched > 0 && H[i] != N[matched]) {
                matched= pm[matched-1];
            }
            if (H[i] == N[matched]) {
                ++matched;
                if (matched == m) {
                    return true;
                }
            }
        }
        return false;
    }
};