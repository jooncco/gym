// https://leetcode.com/problems/number-of-ways-to-split-array/
/***
 * Prefix Sum
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        int n= nums.size();
        vector<long> pSum(n);
        pSum[0]= nums[0];
        for (int i=1; i < n; ++i) pSum[i]= pSum[i-1]+nums[i];

        long tSum= pSum[n-1];
        int ans= 0;
        for (int i=0; i < n-1; ++i) {
            if (pSum[i] >= tSum-pSum[i]) ++ans;
        }
        return ans;
    }
};