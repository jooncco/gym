package leetcode.p1964;
// https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/

/**
 * Monotone Stack (LIS)
 * | Time: O (n logn)
 * | Space: O (n)
 */
public class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n= obstacles.length;
        int[] stack= new int[n], ans= new int[n];
        int size= 0;
        for (int i=0; i < n; ++i) {
            int l= 0, r= size;
            while (l < r) {
                int m= (l + r)/2;
                if (stack[m] <= obstacles[i]) l= m+1;
                else r= m;
            }
            ans[i]= l+1;
            if (l == size) ++size;
            stack[l+1]= obstacles[i];
        }
        return ans;
    }
}
