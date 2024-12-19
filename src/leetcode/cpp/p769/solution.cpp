// https://leetcode.com/problems/max-chunks-to-make-sorted/
/**
 * Prefix Sum
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;

class Solution {
public:
    int maxChunksToSorted(vi& arr) {
        int n= arr.size();
        vi pSumDiff(n+1, 0);
        int ans= 0;
        for (int i=0; i<n; ++i) {
            int diff= arr[i]-i;
            pSumDiff[i+1]= pSumDiff[i]+diff;
            if (pSumDiff[i+1] == 0) ++ans;
        }
        return ans;
    }
};