package leetcode.java.p605;
// https://leetcode.com/problems/can-place-flowers/

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && (i == n - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                ++cnt;
            }
        }
        return cnt >= n;
    }
}