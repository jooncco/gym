// https://leetcode.com/problems/neighboring-bitwise-xor/
/***
 * Array
 * Time: O(n)
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
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    bool doesValidArrayExist(vi& derived) {
        int n= derived.size();
        int bit= 0;
        for (int i=0; i < n; ++i) {
            if (derived[i] == 1) bit ^= 1;
        }
        return bit == 0;
    }
};