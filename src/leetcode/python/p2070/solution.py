"""
https://leetcode.com/problems/most-beautiful-item-for-each-query/
"""


class Solution:
    """
    Sorting, Binary Search
    - Time: O(n log(n))
    - Space: O(n)
    """

    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        items.sort(key=lambda x: (x[0], -x[1]))
        for i in range(1, len(items)):
            items[i][1] = max(items[i][1], items[i - 1][1])
        ans = []
        for q in queries:
            idx = self.binary_search(items, q)
            if idx == 0 and items[idx][0] > q:
                ans.append(0)
                continue
            ans.append(items[idx][1] if items[idx][0] <= q else items[idx - 1][1])
        return ans

    def binary_search(self, items, target):
        left, right = 0, len(items) - 1
        while left < right:
            mid = left + (right - left) // 2
            if items[mid][0] < target:
                left = mid + 1
            else:
                right = mid
        return right
