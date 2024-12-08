// https://leetcode.com/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;

/**
 * Two Pointers
 * Time: O(nlog(n))
 * Space: O(1)
 */
class Solution {
public:
    int maxOperations(vi& nums, int k) {
        int n= nums.size();
        sort(nums.begin(), nums.end());
        int ans= 0, l= 0, r= n-1;
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                ++ans;
                ++l;
                --r;
            } else if (nums[l] + nums[r] < k) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
};