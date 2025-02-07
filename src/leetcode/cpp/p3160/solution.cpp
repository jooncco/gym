// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/
/***
 * Hash Table
 * Time: O(N)
 * Space: O(N)
 */
#include <bits/stdc++.h>
using namespace std;

#define FAST_IO ios_base::sync_with_stdio(0), cin.tie(0);
#define bitcount __builtin_popcount
#define countZeros __builtin_ctz
using ll= long long;
using ld= long double;
using pii= pair<int,int>;
using pll= pair<ll,ll>;
using vb= vector<bool>;
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvb= vector<vb>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    vi queryResults(int limit, vvi& queries) {
        const int N= queries.size();
        unordered_map<int, int> balls, color;
        int distinctColors= 0;
        vi ret;
        ret.reserve(N);
        int cnt= 0;
        for (vi& query : queries) {
            int b= query[0], c= query[1];
            // erase
            if (balls.find(color[b]) != balls.end()) {
                balls[color[b]]--;
                if (balls[color[b]] == 0) --distinctColors;
            }
            // add
            color[b]= c;
            if (balls.find(c) == balls.end() || balls[c] == 0) {
                balls.insert({c, 0});
                ++distinctColors;
            }
            balls[c]++;
            ret.push_back(distinctColors);
        }
        return ret;
    }
};