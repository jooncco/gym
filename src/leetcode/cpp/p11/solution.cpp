// https://leetcode.com/problems/container-with-most-water/
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;

/**
 * Greedy, Two Pointers
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
public:
    int maxArea(vi& h) {
        int n= h.size();
        int ans= 0, l= 0, r= n-1;
        while (l < r) {
            ans= max(ans, (r-l)*min(h[l], h[r]));
            if (h[l] < h[r]) ++l;
            else --r;
        }
        return ans;
    }
};