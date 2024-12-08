// https://leetcode.com/problems/two-best-non-overlapping-events/
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;

/**
 * Greedy
 * Time: O(nlogn)
 * Space: O(2n)
 */
class Solution {
public:
    using info= tuple<int, bool, int>;
    int n;

    int maxTwoEvents(vvi& events) {
        n= events.size();
        vector<info> time(n*2);
        for (int i=0; i < n; ++i) {
            time[2*i]= {events[i][0], 0, events[i][2]};
            time[2*i+1]= {events[i][1], 1, events[i][2]};
        }
        sort(time.begin(), time.end());
        int ans= 0, maxVal= 0;
        for (auto& [t, isEnd, v] : time) {
            if (isEnd) maxVal= max(maxVal, v);
            else ans= max(ans, maxVal+v);
        }
        return ans;
    }
};