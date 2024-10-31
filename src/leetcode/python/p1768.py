"""
https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
"""
class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i= 0
        j= 0
        ret= ""
        while i < len(word1) or j < len(word2):
            if i < len(word1):
                ret= ret + word1[i]
                i= i+1
            if j < len(word2):
                ret= ret + word2[j]
                j= j+1
        return ret