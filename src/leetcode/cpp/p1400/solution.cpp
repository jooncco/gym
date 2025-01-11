// https://leetcode.com/problems/construct-k-palindrome-strings/
/***
 * String, Greedy
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
using vpll= vector<pll>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    bool canConstruct(string s, int k) {
        int n= s.length();
        if (n < k) return false;
        
        vi cnt(26, 0);
        for (int i=0; i < n; ++i) {
            cnt[s[i]-'a']++;
        }
        int odds= 0;
        for (int i=0; i < 26; ++i) {
            if (cnt[i]%2) ++odds;
        }
        return odds <= k;
    }
};