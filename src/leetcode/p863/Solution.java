package leetcode.p863;
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

import java.util.ArrayList;
import java.util.List;

/**
 * Depth First Search
 * | Time: O (n)
 * | Space: O (log n)
 */
public class Solution {
	private List<TreeNode> mainPath= null;
	private List<Integer> ans= new ArrayList<>();
	private boolean[] visited= new boolean[501];

    public List<Integer> distanceK(TreeNode root, TreeNode target, int D) {
		var path = new ArrayList<TreeNode>();
		path.add(root);
		findMainPath(root, target, path);
		int diff= 0;
	    for (int i=mainPath.size()-1; i >= 0; --i) {
			if (D-diff < 0) break;
			addNodeValueInDistance(mainPath.get(i), D-diff);
			++diff;
	    }
		return ans;
    }

	private void findMainPath(TreeNode curr, TreeNode target, List<TreeNode> path) {
		if (curr.val == target.val) {
			mainPath= new ArrayList<>(path);
			return;
		}

		if (curr.left != null) {
			path.add(curr.left);
			findMainPath(curr.left, target, path);
			path.remove(path.size()-1);
		}
		if (curr.right != null) {
			path.add(curr.right);
			findMainPath(curr.right, target, path);
			path.remove(path.size()-1);
		}
	}

	private void addNodeValueInDistance(TreeNode curr, int d) {
		if (curr == null) return;
		if (visited[curr.val]) return;

		System.out.println("curr: " + curr + " , d: " + d);
		visited[curr.val]= true;
		if (d == 0) {
			ans.add(curr.val);
			return;
		}
		addNodeValueInDistance(curr.left, d-1);
		addNodeValueInDistance(curr.right, d-1);
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}