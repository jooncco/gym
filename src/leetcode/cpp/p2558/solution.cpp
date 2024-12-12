// https://leetcode.com/problems/take-gifts-from-the-richest-pile/
/**
 * Priority Queue
 * Time: O((n+k)log(n))
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<int> vi;

class Solution {
public:
    ll pickGifts(vi& gifts, int k) {
        ll ans= 0;
        priority_queue<int, vi, less<int>> pq;
        for (int i=0; i < gifts.size(); ++i) {
            ans += gifts[i];
            pq.push(gifts[i]);
        }
        while (k--) {
            int mx= pq.top();
            pq.pop();
            int r= (int)sqrt(mx);
            ans -= (mx-r);
            pq.push(r);
        }
        return ans;
    }
};