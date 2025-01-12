// https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
/***
 * Stack
 * Time: O(|s|)
 * Space: O(|s|)
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
    bool canBeValid(string s, string locked) {
        int n= s.length();
        stack<int> open, joker;
        for (int i=0; i < n; ++i) {
            if (locked[i] == '0') joker.push(i);
            else {
                if (s[i] == '(') open.push(i);
                else { // ')'
                    if (open.empty() && joker.empty()) return false;
                    if (open.size()) open.pop();
                    else joker.pop();
                }
            }
        }
        while (open.size()) {
            if (joker.empty() || open.top() > joker.top()) return false;
            open.pop();
            joker.pop();
        }
        return joker.size()%2 == 0;
    }
};