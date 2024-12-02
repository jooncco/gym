// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int isPrefixOfWord(string sentence, string searchWord) {
        istringstream iss(sentence);
        string word;
        int idx= 1;
        while (iss >> word) {
            if (isPrefix(word, searchWord)) {
                return idx;
            }
            ++idx;
        }
        return -1;
    }

private:
    bool isPrefix(string word, string searchWord) {
        for (int i=0; i < searchWord.length(); ++i) {
            if (i >= word.length() || word[i] != searchWord[i]) {
                return false;
            }
        }
        return true;
    }
};