"""
https://leetcode.com/problems/circular-sentence/
"""
class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        if sentence[0] != sentence[-1]:
            return False
        words = sentence.split(' ')
        for i, _ in enumerate(words):
            if i == 0:
                continue
            if words[i][0] != words[i-1][-1]:
                return False
        return True