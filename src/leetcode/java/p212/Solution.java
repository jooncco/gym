package leetcode.java.p212;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        TrieNode root = constructTrie(words);
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(board, root, i, j, ans);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, TrieNode node, int y, int x, List<String> ans) {
        if (board[y][x] == '.' || node.next[board[y][x] - 'a'] == null)
            return;

        int idx = board[y][x] - 'a';
        if (node.next[idx].word != null) {
            ans.add(node.next[idx].word);
            node.next[idx].word = null;
        }
        board[y][x] = '.';
        if (y > 0)
            dfs(board, node.next[idx], y - 1, x, ans);
        if (x > 0)
            dfs(board, node.next[idx], y, x - 1, ans);
        if (y < m - 1)
            dfs(board, node.next[idx], y + 1, x, ans);
        if (x < n - 1)
            dfs(board, node.next[idx], y, x + 1, ans);
        board[y][x] = (char) (idx + 'a');
    }

    private TrieNode constructTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode parent = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (parent.next[idx] == null)
                    parent.next[idx] = new TrieNode();
                parent = parent.next[idx];
            }
            parent.word = word;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] next;
    String word;

    TrieNode() {
        next = new TrieNode[26];
    }
}