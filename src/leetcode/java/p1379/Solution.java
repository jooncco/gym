package leetcode.java.p1379;
// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findClonedTarget(cloned, target);
    }

    private boolean isIdentical(final TreeNode curRoot, final TreeNode target) {
        if (curRoot == null && target == null)
            return true;
        if (curRoot == null || target == null)
            return false;

        return curRoot.val == target.val
                && isIdentical(curRoot.left, target.left)
                && isIdentical(curRoot.right, target.right);
    }

    private TreeNode findClonedTarget(final TreeNode currentClonedNode, final TreeNode target) {
        if (currentClonedNode == null)
            return null;

        if (isIdentical(currentClonedNode, target))
            return currentClonedNode;
        TreeNode clonedTarget;
        clonedTarget = findClonedTarget(currentClonedNode.left, target);
        if (clonedTarget != null)
            return clonedTarget;
        clonedTarget = findClonedTarget(currentClonedNode.right, target);
        if (clonedTarget != null)
            return clonedTarget;
        return null;
    }
}