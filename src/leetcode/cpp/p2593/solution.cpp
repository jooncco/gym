// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
/**
 * Sortings
 * Time: O(n·log(n))
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int,int> ii;
typedef vector<int> vi;
typedef vector<ii> vii;
typedef vector<bool> vb;

class Solution {
public:
    ll findScore(vi& nums) {
        int n= nums.size();
        vii list;
        for (int i=0; i < n; ++i) {
            list.push_back({nums[i], i});
        }
        sort(list.begin(), list.end());
        
        vb marked(n, false);
        ll ans= 0;
        for (auto &[num, idx] : list) {
            if (marked[idx]) continue;
            ans += num;
            marked[idx]= true;
            if (idx > 0) marked[idx-1]= true;
            if (idx < n-1) marked[idx+1]= true;
        }
        return ans;
    }
};