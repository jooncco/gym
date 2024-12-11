// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
/**
 * Prefix Sum
 * Time: O(n + 100000)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;

class Solution {
public:
    int maximumBeauty(vi& nums, int k) {
        const int N= 100000;
        vi cnt(N+10, 0);
        for (int i=0; i < nums.size(); ++i) {
            ++cnt[max(0, nums[i]-k)];
            --cnt[min(N+1, nums[i]+k+1)];
        }
        for (int i=1; i <= N; ++i) {
            cnt[i] += cnt[i-1];
        }
        int ans= 0;
        for (int i=0; i <= N; ++i) {
            ans= max(ans, cnt[i]);
        }
        return ans;
    }
};