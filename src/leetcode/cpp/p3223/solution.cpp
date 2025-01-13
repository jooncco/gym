// https://leetcode.com/problems/minimum-length-of-string-after-operations/
/**
 * String
 * Time: O(|s|)
 * Space: O(26)
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
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    int minimumLength(string s) {
        int n= s.length();
        vi cnt(26);
        for (int i=0; i < n; ++i) {
            cnt[s[i]-'a']++;
        }
        int ans= n;
        for (int i=0; i < 26; ++i) {
            while (cnt[i] >= 3) {
                cnt[i] -= 2;
                ans -= 2;
            }
        }
        return ans;
    }
};