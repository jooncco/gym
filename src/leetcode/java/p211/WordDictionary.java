package leetcode.java.p211;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.add(c);
            cur = cur.get(c);
        }
        cur.setEnd(true);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode cur, String word, int curIdx) {
        if (curIdx == word.length() - 1) {
            return cur.isEnd();
        }
        if (word.charAt(curIdx) == '.') {
            boolean exist = false;
            for (char c : cur.getChildren().keySet()) {
                if (search(cur.get(c), word, curIdx + 1))
                    exist = true;
            }
            return exist;
        } else {
            return search(cur.get(word.charAt(curIdx)), word, curIdx + 1);
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean end;

        TrieNode() {
            children = new HashMap<>();
        }

        Map<Character, TrieNode> getChildren() {
            return children;
        }

        TrieNode get(char c) {
            return children.get(c);
        }

        void add(char c) {
            children.put(c, new TrieNode());
        }

        boolean isEnd() {
            return end;
        }

        void setEnd(boolean end) {
            this.end = end;
        }
    }
}