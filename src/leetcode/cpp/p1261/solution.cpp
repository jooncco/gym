// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
/***
 * Trees
 * Time: O(log(n)) for find, and O(n) for FindElements where n is the # of nodes in the tree
 * Space: O(1)
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

class FindElements {
private:
    TreeNode* _root;
    void recover(TreeNode* node) {
        if (node == NULL) return;
        if (node->left != NULL) node->left->val= node->val*2+1;
        if (node->right != NULL) node->right->val= node->val*2+2;
        recover(node->left);
        recover(node->right);
    }

public:
    FindElements(TreeNode* root) {
        _root= root;
        recover(root);
    }
    
    bool find(int target) {
        vi d;
        while (target) {
            int isLeftChild= target%2;
            d.push_back(isLeftChild);
            if (isLeftChild) target= (target-1)/2;
            else target= (target-2)/2;
        }
        TreeNode* node= _root;
        while (d.size()) {
            int goLeft= d.back(); d.pop_back();
            if (goLeft) {
                node= node->left;
            } else {
                node= node->right;
            }
            if (node == NULL) return 0;
        }
        return 1;
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