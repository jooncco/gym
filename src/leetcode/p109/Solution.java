package leetcode.p109;
// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int totalLen= 0;
        ListNode node= head;
        while (node != null) {
            ++totalLen;
            node= node.next;
        }
        return constructTree(head, totalLen);
    }

    private TreeNode constructTree(ListNode fromNode, int len) {
        if (fromNode == null || len == 0) return null;
        if (len == 1) return new TreeNode(fromNode.val);

        int rootIdx= len/2;
        ListNode cur= fromNode;
        for (int i=0; i < rootIdx; ++i) cur= cur.next;
        TreeNode root= new TreeNode(cur.val);
        root.left= constructTree(fromNode, len/2);
        root.right= constructTree(cur.next, len-len/2-1);
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}