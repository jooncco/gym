package leetcode.p1601;

public class Solution {
    private int ans= 0;

    public int maximumRequests(int n, int[][] requests) {
        dfs(n, requests, new int[n], 0, 0);
        return ans;
    }

    private void dfs(int n, int[][] requests, int[] netChanges, int curr, int acceptedRequests) {
        if (curr == requests.length) {
            if (isPossible(netChanges)) {
                ans= Math.max(ans, acceptedRequests);
            }
            return;
        }

        dfs(n, requests, netChanges, curr+1, acceptedRequests);
        --netChanges[requests[curr][0]];
        ++netChanges[requests[curr][1]];
        dfs(n, requests, netChanges, curr+1, acceptedRequests+1);
        --netChanges[requests[curr][1]];
        ++netChanges[requests[curr][0]];
    }

    private boolean isPossible(int[] netChanges) {
        for (int netChange : netChanges) {
            if (netChange != 0) return false;
        }
        return true;
    }
}