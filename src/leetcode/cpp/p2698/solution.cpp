// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
/***
 * Brute Force
 * Time: O(n 2^(2log(n)))
 * Space: O(2^(2log(n)))
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
    int punishmentNumber(int n) {
        auto check= [&](auto self, int target, string num) {
            if (stoi(num) == target) return 1;
            for (int i=1; i < num.length(); ++i) {
                if (self(self, target-stoi(num.substr(0,i)), num.substr(i))) {
                    return 1;
                }
            }
            return 0;
        };
        int ans= 0;
        for (int i=1; i <= n; ++i) {
            if (check(check, i, to_string(i*i))) ans += i*i;
        }
        return ans;
    }
};