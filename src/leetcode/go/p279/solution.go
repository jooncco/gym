/*
Leetcode problem p279 solution.

Dynamic Programming (Top Down)
- Time: O(n sqrt(n)^2)
- Space: O(n)
*/
package p279

var cc [10001]int

func numSquares(n int) int {
	for i:=0; i <= 10000; i++ {
		cc[i]= -1
	}
	return getMinCount(n)
}

func getMinCount(num int) int {
	if cc[num] > -1 {
		return cc[num]
	}

	cc[num]= num
	for i:=1; i*i <= num; i++ {
		cc[num] = min(cc[num], 1 + getMinCount(num-i*i))
	}
	return cc[num]
}

