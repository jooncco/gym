package leetcode.java.p767;
// https://leetcode.com/problems/reorganize-string/

import java.util.*;

/**
 * Contructive Algorithms, Greedy
 * | Time: O (n)
 * | Space: O (n)
 */
public class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
            ++cnt[c - 'a'];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; ++i) {
            pq.add(new int[] { cnt[i], i });
        }
        int[] longest = pq.poll();
        // impossible ?
        if (n - longest[0] < longest[0] - 1)
            return "";

        // construct
        Queue<Character> remaining = new LinkedList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            while (cur[0]-- > 0) {
                remaining.add((char) ('a' + cur[1]));
            }
        }
        String ans = "";
        while (longest[0]-- > 0) {
            ans = ans + (char) ('a' + longest[1]);
            if (!remaining.isEmpty())
                ans += remaining.poll();
        }
        if (!remaining.isEmpty()) {
            char cur = remaining.poll();
            int pos = 1;
            ans = ans.substring(0, pos) + cur + ans.substring(pos);
            while (!remaining.isEmpty()) {
                char nxt = remaining.poll();
                if (cur != nxt) {
                    pos = 1;
                    cur = nxt;
                } else
                    pos += 2;
                ans = ans.substring(0, pos) + nxt + ans.substring(pos);
            }
        }
        return ans;
    }
}
