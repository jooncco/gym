// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
/***
 * String, Brute Force
 * Time: O(HN)
 * Space: O(H)
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
    string removeOccurrences(string s, string part) {
        int H= s.length(), N= part.length();
        string ret;
        for (int i=0; i < H; ++i) {
            ret += s[i];
            if (ret.length() >= N && ret.substr(ret.length()-N) == part) {
                ret= ret.substr(0, ret.length()-N);
            }
        }
        return ret;
    }
};