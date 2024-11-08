"""
https://leetcode.com/problems/string-compression-iii/
"""


class Solution:
    """
    String
    - Time: O(n)
    - Space: O(n)
    """

    def compressedString(self, word: str) -> str:
        comp = ""
        cnt, c = 1, word[0]
        for i in range(1, len(word)):
            if word[i] == c and cnt < 9:
                cnt += 1
            else:
                comp += str(cnt) + c
                c = word[i]
                cnt = 1
        return comp + str(cnt) + c
