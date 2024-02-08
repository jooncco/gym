package leetcode.java.p1611;
// https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

import java.util.*;

/**
 * Greedy, Math
 * | Time: O( H(n)/2 )
 * | Space: O( H(n)/2 )
 * | where H(n) is the Hamming weight of n
 */
public class Solution {
    public int minimumOneBitOperations(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 30; i >= 0; --i) { // O(1)
            if (((1 << i) & n) > 0)
                queue.add(i);
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans += powerOfTwo(queue.poll() + 1) - 1;
            if (!queue.isEmpty()) {
                ans -= powerOfTwo(queue.poll() + 1) - 1;
            }
        }
        return ans;
    }

    private int powerOfTwo(int p) {
        int ret = 1;
        while (p-- > 0)
            ret <<= 1;
        return ret;
    }
}
