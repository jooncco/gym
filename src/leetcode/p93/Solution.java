package leetcode.p93;
// https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ans= new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, new ArrayList<>(), 1);
        return ans;
    }

    private void dfs(String s, List<Integer> indices, int curIdx) {
        if (curIdx > s.length()) return;
        if (indices.size() == 3) {
            String ipAddress= toIpAddress(s, indices);
            if (isValidIpAddress(ipAddress)) ans.add(ipAddress);
            return;
        }
        indices.add(curIdx);
        dfs(s, indices, curIdx+1);
        indices.remove(indices.size()-1);
        dfs(s, indices, curIdx+1);
    }

    private String toIpAddress(String s, List<Integer> indices) {
        StringBuilder sb= new StringBuilder();
        for (int i=0; i < s.length(); ++i) {
            if (indices.contains(i)) sb.append('.');
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private boolean isValidIpAddress(String ipAddress) {
        String[] blocks= ipAddress.split("[.]");
        if (blocks.length != 4) return false;
        for (int i=0; i < blocks.length; ++i) {
            if (blocks[i].length() > 1 && blocks[i].charAt(0) == '0') return false;
            if (blocks[i].length() > 3 || Integer.parseInt(blocks[i]) >= (1<<8)) return false;
        }
        return true;
    }
}