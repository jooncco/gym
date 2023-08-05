package leetcode.p95;
// https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.*;

/**
 * Hashing, Recursion
 * | Time: O (n! * n log(n))
 * | Space: O (n!)
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        Permu permu = new Permu();
        int cnt = 1;
        int[] arr = new int[n];
        for (int i = 1; i <= n; ++i) {
            arr[i - 1] = i;
            cnt *= i;
        }

        List<TreeNode> ans = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < cnt; ++i) {
            TreeNode root = new TreeNode(arr[0]);
            for (int j = 1; j < n; ++j)
                addNode(root, arr[j]);
            String hash = getHash(root);
            if (!hashSet.contains(hash))
                ans.add(root);
            hashSet.add(hash);
            arr = permu.nextPermutation(arr);
        }
        return ans;
    }

    private void addNode(TreeNode node, int num) {
        if (node.val > num) {
            if (node.left == null)
                node.left = new TreeNode(num);
            else
                addNode(node.left, num);
        } else {
            if (node.right == null)
                node.right = new TreeNode(num);
            else
                addNode(node.right, num);
        }
    }

    private String getHash(TreeNode root) {
        if (root == null)
            return null;

        String hash = root.val + "";
        String left = getHash(root.left);
        if (left != null)
            hash += "," + left;
        String right = getHash(root.right);
        if (right != null)
            hash += "," + right;
        return hash;
    }

    static class Permu {
        int[] nextPermutation(int[] arr) {
            int n = arr.length;
            int[] ret = new int[n];
            for (int i = 0; i < n; ++i)
                ret[i] = arr[i];
            int pivot = n - 1;
            while (pivot > 0 && ret[pivot - 1] >= ret[pivot])
                --pivot;
            if (pivot > 0) {
                --pivot;
                int idx = n - 1;
                while (ret[idx] <= ret[pivot])
                    --idx;
                swap(ret, pivot, idx);
                reverse(ret, pivot + 1, n - 1);
            } else {
                Arrays.sort(ret);
            }
            return ret;
        }

        void swap(int[] arr, int a, int b) {
            int tmp = arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        void reverse(int[] arr, int l, int r) {
            int[] buf = new int[r - l + 1];
            for (int i = l; i <= r; ++i)
                buf[i - l] = arr[r - (i - l)];
            for (int i = 0; i < r - l + 1; ++i)
                arr[l + i] = buf[i];
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}