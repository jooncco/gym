// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/
/***
 * Priority Queue
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
    int minOperations(vi& nums, int k) {
        priority_queue<ll, vll, greater<ll>> pq;
        for (int num : nums) {
            pq.push(num);
        }
        int ans= 0;
        while (pq.size() > 1 && pq.top() < k) {
            int a= pq.top(); pq.pop();
            int b= pq.top(); pq.pop();
            pq.push(a*2ll+b);
            ++ans;
        }
        return ans;
    }
};