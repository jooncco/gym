package leetcode.p1239;
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

import java.util.List;

public class Solution {
    private int n, ans;
    private boolean[] mask;

    public int maxLength(List<String> arr) {
        n= arr.size(); ans= 0;
        mask= new boolean[26];
        dfs(arr, 0, 0);
        return ans;
    }

    private boolean isItselfDistinctive(String str) {
        boolean[] exist= new boolean[26];
        for (char c : str.toCharArray()) {
            int idx= c-'a';
            if (exist[idx]) return false;
            exist[idx]= true;
        }
        return true;
    }

    private void dfs(List<String> arr, int idx, int curLen) {
        if (idx == n) {
            ans= Math.max(ans, curLen);
            return;
        }

        String curStr= arr.get(idx);
        boolean exclusive= true;
        for (char c : curStr.toCharArray()) {
            if (mask[c-'a']) {
                exclusive= false;
                break;
            }
        }
        if (exclusive && isItselfDistinctive(curStr)) {
            for (char c : curStr.toCharArray()) mask[c-'a']= true;
            dfs(arr, idx+1, curLen+curStr.length());
            for (char c : curStr.toCharArray()) mask[c-'a']= false;
        }
        dfs(arr, idx+1, curLen);
    }
}

//public class Solution {
//    private int n;
//    private int[][] cache;
//
//    public int maxLength(List<String> arr) {
//        n= arr.size();
//        cache= new int[n][1<<26];
//        for (int i=0; i < n; ++i) Arrays.fill(cache[i], -1);
//        return find(arr, 0, 0);
//    }
//
//    private int find(final List<String> arr, int idx, int bitMask) {
//        if (idx == n) return 0;
//        if (cache[idx][bitMask] > -1) return cache[idx][bitMask];
//
//        cache[idx][bitMask]= 0;
//        String str= arr.get(idx);
//        boolean exclusive= true;
//        for (char c : str.toCharArray()) {
//            if ((bitMask & (1<<(c-'a'))) > 0) {
//                exclusive= false;
//                break;
//            }
//        }
//        if (exclusive) {
//            int newBitMask= bitMask;
//            for (char c : str.toCharArray()) newBitMask |= (1<<(c-'a'));
//            cache[idx][bitMask]= Math.max(cache[idx][bitMask], find(arr, idx+1, newBitMask));
//        }
//        cache[idx][bitMask]= Math.max(cache[idx][bitMask], find(arr, idx+1, bitMask));
//        return cache[idx][bitMask];
//    }
//}