package leetcode.p139;
// https://leetcode.com/problems/word-break/

import java.util.*;

/**
 * Trie, DP
 * | Time: O (len(S)*len(word))
 * | Space: O (len(wordDict)*len(word) + len(S))
 */
public class Solution {
    TrieNode trie = new TrieNode('.');
    int[] cache;

    public boolean wordBreak(String S, List<String> wordDict) {
        int n = S.length();
        cache = new int[n];
        for (int i = 0; i < n; ++i)
            cache[i] = -1;
        for (String word : wordDict)
            trie.addWord(word);
        return isBreakable(S, 0) == 1;
    }

    private int isBreakable(String S, int idx) {
        if (idx == S.length())
            return 1;
        if (cache[idx] > -1)
            return cache[idx];

        cache[idx] = 0;
        for (int i = idx + 1; i <= S.length(); ++i) {
            if (trie.findWord(S.substring(idx, i)) && isBreakable(S, i) == 1)
                cache[idx] = 1;
        }
        return cache[idx];
    }

    static class TrieNode {
        char val;
        boolean exist;
        Map<Character, TrieNode> children;

        TrieNode(char val) {
            this.val = val;
            children = new HashMap<>();
        }

        char getVal() {
            return val;
        }

        void setVal(char val) {
            this.val = val;
        }

        void addChild(TrieNode node) {
            children.put(node.getVal(), node);
        }

        TrieNode getChild(char c) {
            return children.get(c);
        }

        boolean findWord(String word) {
            if (word.length() == 0)
                return exist;
            if (!children.containsKey(word.charAt(0)))
                return false;
            return children.get(word.charAt(0)).findWord(word.substring(1));
        }

        void addWord(String word) {
            if (word.length() == 0) {
                exist = true;
                return;
            }
            TrieNode child = children.get(word.charAt(0));
            if (child == null) {
                addChild(new TrieNode(word.charAt(0)));
                child = children.get(word.charAt(0));
            }
            child.addWord(word.substring(1));
        }
    }
}