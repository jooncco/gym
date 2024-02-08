package leetcode.java.p1268;
// https://leetcode.com/problems/search-suggestions-system/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<String>> suggestedProducts(final String[] products, final String searchWord) {
        TreeNode root = new TreeNode();
        // insert words
        for (final String product : products) {
            TreeNode curNode = root;
            for (final char c : product.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    curNode.children[c - 'a'] = new TreeNode();
                }
                curNode.children[c - 'a'].addToSuggestions(product);
                curNode = curNode.children[c - 'a'];
            }
        }

        // find suggestions
        List<List<String>> ans = new ArrayList<>();
        TreeNode curNode = root;
        for (final char c : searchWord.toCharArray()) {
            curNode = curNode.children[c - 'a'];
            if (curNode == null)
                break;

            ans.add(curNode.getSuggestions());
        }
        while (ans.size() < searchWord.length()) {
            ans.add(new ArrayList<>());
        }
        return ans;
    }
}

class TreeNode {
    TreeNode[] children;
    PriorityQueue<String> suggestions;

    TreeNode() {
        this.children = new TreeNode[26];
        this.suggestions = new PriorityQueue<>((a, b) -> b.compareTo(a));
    }

    void addToSuggestions(final String word) {
        this.suggestions.add(word);
        while (suggestions.size() > 3)
            suggestions.poll();
    }

    List<String> getSuggestions() {
        List<String> ret = new ArrayList<>();
        while (!suggestions.isEmpty()) {
            ret.add(suggestions.poll());
        }
        Collections.reverse(ret);
        return ret;
    }
}