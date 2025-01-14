// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
/***
 * Array, Bitmask
 * Time: O(n)
 * Space: O(n)
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
    vi findThePrefixCommonArray(vi& A, vi& B) {
        ll mask= 0;
        int prefCommon= 0;
        vi ans(A.size());
        for (int i=0; i < A.size(); ++i) {
            if (mask & (1ll<<A[i])) ++prefCommon;
            else mask |= (1ll<<A[i]);
            if (mask & (1ll<<B[i])) ++prefCommon;
            else mask |= (1ll<<B[i]);
            ans[i]= prefCommon;
        }
        return ans;
    }
};