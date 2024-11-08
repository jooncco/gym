"""
https://leetcode.com/problems/maximum-xor-for-each-query/
"""


class Solution:
    """
    Bitmask, Greedy
    - Time: O(n)
    - Space: O(n)
    """

    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        ans = []
        mask = (1 << maximumBit) - 1
        nums_mask = 0
        for num in nums:
            nums_mask ^= num
        ans.append((nums_mask ^ mask) & mask)
        for num in nums[::-1][:-1]:
            nums_mask ^= num
            ans.append((nums_mask ^ mask) & mask)
        return ans
