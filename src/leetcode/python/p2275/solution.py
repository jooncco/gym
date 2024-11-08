"""
https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
"""


class Solution:
    """
    Bitmask
    - Time: O(32n)
    - Space: O(1)
    """

    def largestCombination(self, candidates: List[int]) -> int:
        ans = 0
        for i in range(32):
            cnt = 0
            for num in candidates:
                if num & (1 << i):
                    cnt += 1
            ans = max(ans, cnt)
        return ans
