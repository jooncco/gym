package leetcode.p881;
// https://leetcode.com/problems/boats-to-save-people/

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int minimumBoats= 0;
        int l= 0, r= people.length-1;
        while (l < r) {
            ++minimumBoats;
            if (people[l] + people[r] <= limit) ++l;
            --r;
        }
        if (l == r) ++minimumBoats;
        return minimumBoats;
    }
}