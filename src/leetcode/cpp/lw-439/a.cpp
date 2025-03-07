// https://leetcode.com/problems/find-the-largest-almost-missing-integer/
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
    int largestInteger(vi& nums, int k) {
        const int N= nums.size();
        auto getElementSet= [&](int l, int r) -> set<int> {
            set<int> ret;
            for (int i=l; i <= r; ++i) {
                ret.insert(nums[i]);
            }
            return ret;
        };
        
        vi cnt(51, 0);
        for (int i=k-1; i < N; ++i) {
            set<int> s= getElementSet(i-k+1, i);
            for (int num : s) {
                cnt[num]++;
            }
        }

        int ans= -1;
        for (int i=0; i <= 50; ++i) {
            if (cnt[i] == 1) ans= i;
        }
        return ans;
    }
};