package leetcode.java.p472;
// https://leetcode.com/problems/concatenated-words/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private TrieNode root = new TrieNode('.');

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // init Trie
        TrieNode cur;
        for (String word : words) {
            cur = root;
            for (char c : word.toCharArray()) {
                cur.addChild(c);
                cur = cur.next(c);
            }
            cur.markEndOfWord();
        }

        // iterate
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (dfs(root, word, 0, 1))
                ans.add(word);
        }
        return ans;
    }

    private boolean dfs(TrieNode curNode, String word, int curIdx, int curCnt) {
        if (curNode == null)
            return false;
        if (curIdx == word.length()) {
            return curCnt > 1 && curNode.isEndOfWord();
        }

        boolean ret = false;
        if (curNode.isEndOfWord()) {
            if (dfs(root.next(word.charAt(curIdx)), word, curIdx + 1, curCnt + 1))
                ret = true;
        }
        if (dfs(curNode.next(word.charAt(curIdx)), word, curIdx + 1, curCnt))
            ret = true;
        return ret;
    }
}

class TrieNode {
    char c;
    private TrieNode[] children;
    private boolean endOfWord;

    TrieNode(char c) {
        this.c = c;
        children = new TrieNode[26];
        endOfWord = false;
    }

    void addChild(char c) {
        if (children[c - 'a'] != null)
            return;
        children[c - 'a'] = new TrieNode(c);
    }

    TrieNode next(char c) {
        return children[c - 'a'];
    }

    void markEndOfWord() {
        endOfWord = true;
    }

    boolean isEndOfWord() {
        return endOfWord;
    }
}