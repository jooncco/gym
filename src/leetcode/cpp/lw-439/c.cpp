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

const int INF = 1e8 + 7;

class Solution {
public:
    int maxSum(vi& nums, int k, int m) {
        const int N= nums.size();
        
        int cache[2000][2000];
        memset(cache, -1, sizeof(cache));
        auto dp= [&](auto self, int idx, int cnt) {
            if (cnt == 0) return 0;
            if (idx == N || N-idx < m) return -INF;
            
            int& ret= cache[idx][cnt];
            if (ret > -1) return ret;

            ret= 0;
            int sum= 0, len= m-1;
            for (int i=idx; i < idx+m-1; ++i) {
                sum += nums[i];
            }
            for (int i=idx+m-1; i < N; ++i) {
                sum += nums[i];
                ++len;
                while (len > m && nums[i-len] < 0) {
                    sum -= nums[i-len];
                    --len;
                }
                ret= max(ret, sum+self(self, i+1, cnt-1));
            }
            return ret;
        };

        return dp(dp, 0, k);
    }
};