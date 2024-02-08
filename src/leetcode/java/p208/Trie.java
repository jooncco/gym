package leetcode.java.p208;
// https://leetcode.com/problems/implement-trie-prefix-tree/

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.get(c) == null)
                cur.insert(c);
            cur = cur.get(c);
        }
        cur.setLeafAtLeastOnce(true);
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.get(c) == null)
                return false;
            cur = cur.get(c);
        }
        return cur.isLeafAtLeastOnce();
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.get(c) == null)
                return false;
            cur = cur.get(c);
        }
        return true;
    }

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean leafAtLeastOnce;

        TrieNode() {
            children = new HashMap<>();
            leafAtLeastOnce = false;
        }

        void insert(char c) {
            children.put(c, new TrieNode());
        }

        TrieNode get(char c) {
            return children.get(c);
        }

        boolean isLeafAtLeastOnce() {
            return leafAtLeastOnce;
        }

        void setLeafAtLeastOnce(boolean leafAtLeastOnce) {
            this.leafAtLeastOnce = leafAtLeastOnce;
        }
    }
}