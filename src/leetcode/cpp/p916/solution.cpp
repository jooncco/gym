// https://leetcode.com/problems/word-subsets/
/***
 * String
 * Time: O(n|word|+m|word|)
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
using vs= vector<string>;
using vpll= vector<pll>;
using vvi= vector<vi>;
using vvll= vector<vll>;
using vvpll= vector<vpll>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;

class Solution {
public:
    vs wordSubsets(vs& words1, vs& words2) {
        vvi words1Vec;
        for (string word : words1) {
            words1Vec.push_back(toVector(word));
        }
        vi maxVec(26);
        for (string word : words2) {
            vi vec= toVector(word);
            for (int i=0; i < 26; ++i) {
                maxVec[i]= max(maxVec[i], vec[i]);
            }
        }

        vs ans;
        for (int i=0; i < words1.size(); ++i) {
            if (isSubset(words1Vec[i], maxVec)) {
                ans.push_back(words1[i]);
            }
        }
        return ans;
    }

private:
    vi toVector(string word) {
        vi ret(26);
        for (char c : word) {
            ret[c-'a']++;
        }
        return ret;
    }

    bool isSubset(vi& a, vi& b) {
        for (int i=0; i < a.size(); ++i) {
            if (a[i] < b[i]) return false;
        }
        return true;
    }
};