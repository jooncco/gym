// https://leetcode.com/problems/clear-digits/
/***
 * String, Stack
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
    string clearDigits(string s) {
        auto isDigit= [&](char c) {
            int d= c-'0';
            return d >= 0 && d < 10;
        };

        vector<char> vec;
        for (char c : s) {
            if (!isDigit(c)) vec.push_back(c);
            else vec.pop_back();
        }
        string ret;
        for (char c : vec) {
            ret += c;
        }
        return ret;
    }
};