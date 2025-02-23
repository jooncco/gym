// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
/***
 * Tree
 * Time: O(n^2)
 * Space: O(log(n))
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
    TreeNode* constructFromPrePost(vi& pre, vi& post) {
        const int N= pre.size();
        auto construct= [&](auto self, TreeNode* node, int l, int r, int L, int R) -> void {
            node->val= pre[l];
            if (l == r) return;
            
            // Calculate # of left children
            int loc= -1;
            for (int i=L; i <= R-1; ++i) {
                if (post[i] == pre[l+1]) {
                    loc= i;
                    break;
                }
            }

            int cnt= loc-L+1;
            // Construct left
            if (cnt > 0) {
                node->left= new TreeNode();
                self(self, node->left, l+1, l+cnt, L, L+cnt-1);
            }
            // Construct right
            if (r-l-cnt > 0) {
                node->right= new TreeNode();
                self(self, node->right, l+cnt+1, r, L+cnt, R-1);
            }
        };
        TreeNode* root= new TreeNode();
        construct(construct, root, 0, N-1, 0, N-1);
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