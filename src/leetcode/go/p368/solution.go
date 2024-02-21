/*
Leetcode p368 solution

Sortings, Dynamic Programming(Bottom-up)
- Time: O(n^2)
- Space: O(n)
*/
package p368

import (
	"sort"
)

func largestDivisibleSubset(nums []int) []int {
	sort.Ints(nums)
	subsets := [][]int{} // largest subset which ends with i-th element.
	ans := []int{}
	for i, num := range nums {
		subset := []int{num}
		for j := 0; j < i; j++ {
			if num%nums[j] == 0 && len(subset) < len(subsets[j])+1 {
				subset = make([]int, len(subsets[j])+1)
				copy(subset, subsets[j])
				subset[len(subsets[j])] = num
			}
		}
		subsets = append(subsets, subset)
		if len(subset) > len(ans) {
			ans = subset
		}
	}
	return ans
}
