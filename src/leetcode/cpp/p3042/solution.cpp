// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/
/***
 * String
 * Time: O(2|N|n^2)
 * Space: O(1)
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
    int countPrefixSuffixPairs(vector<string>& words) {
        int n= words.size();
        int ans= 0;
        for (int i=0; i < n; ++i) {
            for (int j=i+1; j < n; ++j) {
                if (isPrefixAndSuffix(words[j], words[i])) {
                    ++ans;
                }
            }
        }
        return ans;
    }

private:
    bool isPrefixAndSuffix(string H, string N) {
        int n= H.length(), m= N.length();
        if (n < m) return false;

        for (int i=0; i < m; ++i) {
            if (H[i] != N[i]) return false;
        }
        for (int i=0; i < m; ++i) {
            if (H[n-1-i] != N[m-1-i]) return false;
        }
        return true;
    }
};