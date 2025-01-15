// https://leetcode.com/problems/minimize-xor/
/***
 * Bitmask, Greedy
 * Time: O(log(num1)+log(num2))
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
    int minimizeXor(int num1, int num2) {
        int x= num1;
        int xBits= bitcount(x), num2Bits= bitcount(num2);
        while (num2Bits < xBits) {
            x &= ~(1<<countZeros(x));
            --xBits;
        }
        int idx= 0;
        while (num2Bits > xBits) {
            if ((x&(1<<idx)) == 0) {
                x |= (1<<idx);
                ++xBits;
            }
            ++idx;
        }
        return x;
    }
};