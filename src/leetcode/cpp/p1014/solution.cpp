// https://leetcode.com/problems/best-sightseeing-pair/
/***
 * DP
 * Time: O(n)
 * Space: O(1)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& values) {
        int ans= 0;
        int l= values[0];
        for (int i=1; i < values.size(); ++i) {
            l--;
            ans= max(ans, l+values[i]);
            l= max(l, values[i]);
        }
        return ans;
    }
};