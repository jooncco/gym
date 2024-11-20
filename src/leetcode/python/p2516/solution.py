"""
https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
"""


class Solution:
    """
    Two Pointers, Sliding Window
    - Time: O(n)
    - Space: O(1)
    """

    def takeCharacters(self, s: str, k: int) -> int:
        lim = {c: s.count(c) - k for c in "abc"}
        if min(lim.values()) < 0:
            return -1
        freq, mx, l = {c: 0 for c in "abc"}, 0, 0
        for r, c in enumerate(s):
            freq[c] += 1
            while freq[c] > lim[c]:
                freq[s[l]] -= 1
                l += 1
            mx = max(mx, r - l + 1)
        return len(s) - mx
