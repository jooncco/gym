// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
/***
 * Sortings, Priority Queue
 * Time: O(n log(n))
 * Space: O(n)
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
using vi= vector<int>;
using vll= vector<ll>;
using vpii= vector<pii>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

struct Comparator {
    bool operator()(pii &a, pii &b) {
        return a.first < b.first;
    }
};

class Solution {
public:
    vi lexicographicallySmallestArray(vi& nums, int limit) {
        int n= nums.size();
        vpii arr;
        for (int i=0; i < n; ++i) {
            arr.push_back({nums[i], i});
        }
        sort(arr.begin(), arr.end(), Comparator());
        
        vi ret(n);
        priority_queue<int, vi, greater<int>> pq;
        pq.push(arr[0].second);
        queue<int> buf;
        buf.push(arr[0].first);
        for (int i=1; i < n; ++i) {
            auto [num, idx]= arr[i];
            if (num-arr[i-1].first > limit) {
                while (pq.size()) {
                    ret[pq.top()]= buf.front();
                    pq.pop();
                    buf.pop();
                }
            }
            pq.push(idx);
            buf.push(num);
        }
        while (pq.size()) {
            ret[pq.top()]= buf.front();
            pq.pop();
            buf.pop();
        }
        return ret;
    }
};