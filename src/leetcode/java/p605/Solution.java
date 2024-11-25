package leetcode.java.p605;
// https://leetcode.com/problems/can-place-flowers/

/**
 * Array, Greedy
 * Time: O(n)
 * Space: O(1)
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int mx= 0;
        for (int i=0; i < flowerbed.length; ++i) {
            int flowers= 0;
            if (i > 0) flowers += flowerbed[i - 1];
            flowers += flowerbed[i];
            if (i < flowerbed.length - 1) flowers += flowerbed[i+1];
            if (flowers == 0) {
                flowerbed[i] = 1;
                ++mx;
            }
        }
        return mx >= n;
    }
}