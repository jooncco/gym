// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
/**
 * BFS
 * Time: O(n)
 * Space: O(n)
 */
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    TreeNode* reverseOddLevels(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        bool odd= false;
        while (!q.empty()) {
            int n= q.size();
            vector<TreeNode*> s;
            for (int i=0; i < n; ++i) {
                s.push_back(q.front());
                q.pop();
                if (s.back()->left != NULL) q.push(s.back()->left);
                if (s.back()->right != NULL) q.push(s.back()->right);
            }
            if (odd) {
                for (int i=0; i < n/2; ++i) {
                    swap(s[i]->val, s[n-1-i]->val);
                }
            }
            odd= !odd;
        }
        return root;
    }
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};