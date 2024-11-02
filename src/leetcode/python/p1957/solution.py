"""
https://leetcode.com/problems/delete-characters-to-make-fancy-string/
"""
class Solution:
    def makeFancyString(self, s: str) -> str:
        ret= s[0]
        cnt= 1
        for i in range(1, len(s)):
            if s[i] == ret[-1]:
                if cnt < 2:
                    ret += s[i]
                    cnt += 1
            else:
                ret += s[i]
                cnt= 1
        return ret