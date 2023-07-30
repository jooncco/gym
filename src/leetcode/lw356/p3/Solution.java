package leetcode.lw356.p3;
// https://leetcode.com/contest/weekly-contest-356/problems/shortest-string-that-contains-three-strings/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Greedy, Brute Force
 * | Time: O (len(a)+len(b)+len(b))
 * | Space: O (1)
 */
public class Solution {
    public String minimumString(String a, String b, String c) {
        String[] arr= {a, b, c};
        Arrays.sort(arr, (A,B) -> A.length() == B.length() ? A.compareTo(B) : A.length()-B.length());
        if (arr[1].contains(arr[0]) || arr[2].contains(arr[0])) arr[0]= "";
        if (arr[2].contains(arr[1])) arr[1]= "";

        List<String> list= new ArrayList<>();
        list.add(optimalConcat(arr[0],arr[1],arr[2]));
        list.add(optimalConcat(arr[0],arr[2],arr[1]));
        list.add(optimalConcat(arr[1],arr[0],arr[2]));
        list.add(optimalConcat(arr[1],arr[2],arr[0]));
        list.add(optimalConcat(arr[2],arr[0],arr[1]));
        list.add(optimalConcat(arr[2],arr[1],arr[0]));
        Collections.sort(list, (A,B) -> A.length() == B.length() ? A.compareTo(B) : A.length()-B.length());
        return list.get(0);
    }

    private String optimalConcat(String a, String b, String c) {
        int len1= longestOverlapLen(a, b), len2= longestOverlapLen(b, c);
        return a.substring(0, a.length()-len1) + b.substring(0, b.length()-len2) + c;
    }

    private int longestOverlapLen(String a, String b) {
        int len= Math.min(a.length(), b.length());
        while (len > 0) {
            if (a.substring(a.length()-len).equals(b.substring(0, len))) {
                return len;
            }
            --len;
        }
        return len;
    }
}