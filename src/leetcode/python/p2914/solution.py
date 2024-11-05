"""
https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
"""
class Solution:
    """
    String, Greedy
    - Time: O(n)
    - Space: O(1)
    """
    def minChanges(self, s: str) -> int:
        i= 1
        ans= 0
        while i < len(s):
            if s[i] != s[i-1]:
                ans += 1
            i += 2
        return ans