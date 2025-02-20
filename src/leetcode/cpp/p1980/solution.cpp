// https://leetcode.com/problems/find-unique-binary-string/
/***
 * Sortings
 * Time: O(|nums| log(|nums|))
 * Space: O(|nums|)
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
    string findDifferentBinaryString(vector<string>& nums) {
        const int N= nums[0].size();
        auto binToInt= [&](string& str) {
            int ret= 0;
            for (int i=0; i < N; ++i) {
                if (str[N-1-i] == '1') ret += (1<<i);
            }
            return ret;
        };
        auto intToBin= [&](int i) {
            string ret(N, '0');
            for (int idx=0; idx < N; ++idx) {
                if (i&(1<<(N-1-idx))) ret[idx]= '1';
            }
            return ret;
        };

        vi vals;
        for (string& num : nums) {
            vals.push_back(binToInt(num));
        }
        sort(vals.begin(), vals.end());
        for (int i=0; i < vals.size(); ++i) {
            if (vals[i] != i) return intToBin(i);
        }
        return string(N, '1');
    }
};