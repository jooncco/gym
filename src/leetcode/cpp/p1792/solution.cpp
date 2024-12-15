// https://leetcode.com/problems/maximum-average-pass-ratio/
/**
 * Greedy
 * Time: O((n+n)log(n))
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
typedef vector<vi> vvi;
typedef pair<int,int> ii;
typedef vector<ii> vii;

class Solution {
public:
    double maxAverageRatio(vvi& classes, int extraStudents) {
        auto comparator= [](ii a, ii b) {
            double rA= (double)a.first/a.second;
            double rANext= (double)(a.first+1)/(a.second+1);
            double rB= (double)b.first/b.second;
            double rBNext= (double)(b.first+1)/(b.second+1);
            return rANext-rA < rBNext-rB;
        };
        priority_queue<ii, vii, decltype(comparator)> pq(comparator);
        for (vi cls : classes) {
            pq.push({cls[0], cls[1]}); // O(log(n))
        }
        while (extraStudents--) {
            ii s= pq.top(); pq.pop();
            s.first++;
            s.second++;
            pq.push(s);
        }
        double ans= 0;
        double total= pq.size();
        while (!pq.empty()) {
            ii cur= pq.top(); pq.pop();
            double avg= (double)cur.first;
            ans += avg/cur.second;
        }
        return ans/total;
    }
};