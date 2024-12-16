// https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
/**
 * Priority Queue
 * Time: O((n+k)log(n))
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
typedef pair<int,int> ii;
typedef vector<ii> vii;

class Solution {
public:
    vi getFinalState(vi& nums, int k, int m) {
        int n= nums.size();
        priority_queue<ii, vii, greater<ii>> pq; // minHeap
        for (int i=0; i < n; ++i) {
            pq.push({nums[i], i});
        }
        while (k--) {
            ii cur= pq.top(); pq.pop();
            int idx= cur.second, val= cur.first;
            nums[idx]= val*m;
            pq.push({val*m, idx});
        }
        return nums;
    }
};