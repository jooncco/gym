// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
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
    bool check(vi& nums) {
        int n= nums.size();
        int cnt= 0;
        if (nums[n-1] > nums[0]) ++cnt;
        for (int i=1; i < n; ++i) {
            if (nums[i] < nums[i-1]) ++cnt;
        }
        return cnt < 2;
    }
};