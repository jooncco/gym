// https://leetcode.com/problems/target-sum/
/***
 * DP
 * Time: O(n|sum|)
 * Space: O(n|sum|)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    const int OFFSET= 1000;
    int ans= 0;
    int _target;
    vector<vector<int>> cache;

    int numOfWays(vector<int>& nums, int idx, int val) {
        if (idx == nums.size()) {
            return val == _target ? 1 : 0;
        }
        
        int& ret= cache[idx][val+OFFSET];
        if (ret > -1) return ret;
        ret= 0;
        ret += numOfWays(nums, idx+1, val+nums[idx]);
        ret += numOfWays(nums, idx+1, val-nums[idx]);
        return ret;
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        _target= target;
        cache= vector<vector<int>>(nums.size());
        for (int i=0; i < nums.size(); ++i) {
            cache[i]= vector<int>(2020, -1);
        }
        return numOfWays(nums, 0, 0);
    }
};