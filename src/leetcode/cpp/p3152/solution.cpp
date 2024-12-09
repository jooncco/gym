// https://leetcode.com/problems/special-array-ii/
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
typedef vector<bool> vb;
typedef vector<vi> vvi;

/**
 * Prefix Sum
 * Time: O(n+m)
 * Space: O(n+m)
 */
class Solution {
public:
    vb isArraySpecial(vi& nums, vvi& queries) {
        int n= nums.size();
        vi notSpecial(n);
        for (int i=1; i < n; ++i) {
            notSpecial[i]= ((nums[i]^nums[i-1])&1) == 0;
        }
        for (int i=1; i < n; ++i) {
            notSpecial[i] += notSpecial[i-1];
        }
        vb ans;
        for (vi &query : queries) {
            int from= query[0], to= query[1];
            ans.push_back(notSpecial[to]-notSpecial[from] == 0);
        }
        return ans;
    }
};