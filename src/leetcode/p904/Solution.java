package leetcode.p904;
// https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int totalFruit(int[] fruits) {
        int ans= 0, cnt= 0;
        Set<Integer> types= new HashSet<>();
        for (int i=0; i < fruits.length; ++i) {
            if (types.size() < 2 || types.contains(fruits[i])) {
                if (!types.contains(fruits[i])) types.add(fruits[i]);
                ++cnt;
            } else {
                types.clear();
                types.add(fruits[i]);
                types.add(fruits[i-1]);
                cnt= 2;
                int idx= i-1;
                while (idx >= 0 && types.contains(fruits[idx])) {
                    --idx;
                    ++cnt;
                }
            }
            ans= Math.max(ans, cnt);
        }
        return ans;
    }
}