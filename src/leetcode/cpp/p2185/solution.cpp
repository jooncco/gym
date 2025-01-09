// https://leetcode.com/problems/counting-words-with-a-given-prefix/
/***
 * String
 * Time: O(n|pref|)
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
    int prefixCount(vector<string>& words, string pref) {
        int ans= 0;
        for (string word : words) {
            if (isPrefix(word, pref)) ++ans;
        }
        return ans;
    }

private:
    bool isPrefix(string& H, string& N) {
        int n= H.length(), m= N.length();
        if (n < m) return false;
        for (int i=0; i < m; ++i) {
            if (H[i] != N[i]) return false;
        }
        return true;
    }
};