// https://leetcode.com/problems/apply-operations-to-an-array/
/***
 * Array
 * Time: O(N)
 * Space: O(N)
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

const ll MOD = (ll)998244353;
const ll INF = (ll)2e18 + 7;

class Solution {
public:
    vi applyOperations(vi& nums) {
        const int N= nums.size();
        vi ret(N, 0);
        int idx= 0;
        for (int i=0; i < N; ++i) {
            if (nums[i] == 0) continue;
            if (i < N-1 && nums[i] == nums[i+1]) {
                ret[idx++]= nums[i]*2;
                nums[i+1]= 0;
            } else {
                ret[idx++]= nums[i];
            }
        }
        return ret;
    }
};