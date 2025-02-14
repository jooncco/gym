// https://leetcode.com/problems/product-of-the-last-k-numbers/
/***
 * Prefix Sum
 * Time: O(1) for both add, getProduct
 * Space: O(k)
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

class ProductOfNumbers {
private:
    vi mul;

public:
    ProductOfNumbers() {
        mul= vi(1, 1);
    }
    
    void add(int num) {
        if (num == 0) {
            mul= vi(1, 1);
        } else {
            if (mul.empty()) mul.push_back(num);
            else mul.push_back(mul.back()*num);
        }
    }
    
    int getProduct(int k) {
        if (mul.size() <= k) return 0;
        
        int r= mul.size()-1;
        return mul[r]/mul[r-k];
    }
};