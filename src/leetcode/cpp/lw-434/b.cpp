// https://leetcode.com/problems/count-mentions-per-user/
/***
 * String
 * Time: O(n|s|)
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
using vvs= vector<vector<string>>;
using maxHeap= priority_queue<int, vector<int>, less<int>>;
using minHeap= priority_queue<int, vector<int>, greater<int>>;


class Solution {
public:
    vi countMentions(int n, vvs& events) {
        vvi offline(n, vi());
        for (vector<string>& event : events) {
            string type= event[0];
            if (type == "OFFLINE") {
                int time= stoi(event[1]);
                int id= stoi(event[2]);
                offline[id].push_back(time);
            }
        }
        auto isOnline= [&](int id, int time) {
            for (int t : offline[id]) {
                if (t <= time && time < t+60) return 0;
            }
            return 1;
        };

        vi mentioned(n, 0);
        for (vector<string>& event : events) {
            string type= event[0];
            if (type == "MESSAGE") {
                int time= stoi(event[1]);
                string ids= event[2];
                if (ids == "ALL") {
                    for (int i=0; i < n; ++i) {
                        ++mentioned[i];
                    }
                }
                else if (ids == "HERE") {
                    for (int i=0; i < n; ++i) {
                        if (isOnline(i, time)) ++mentioned[i];
                    }
                }
                else {
                    stringstream ss(ids);
                    string id;
                    while (ss >> id) {
                        int idx= stoi(id.substr(2));
                        ++mentioned[idx];
                    }
                }
            }
        }
        return mentioned;
    }
};