// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
/**
 * Brute Force
 * Time: O(n^2)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;

class Solution {
public:
    vi finalPrices(vi& prices) {
        int n= prices.size();
        vi ans(n);
        for (int i=0; i < n; ++i) {
            int p= prices[i];
            for (int j=i+1; j < n; ++j) {
                if (p >= prices[j]) {
                    p -= prices[j];
                    break;
                }
            }
            ans[i]= p;
        }
        return ans;
    }
};