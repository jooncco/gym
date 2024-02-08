package leetcode.java.p71;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String simplifyPath(String path) {
        List<String> files = Arrays.stream(path.split("/"))
                .filter(file -> file.length() > 0)
                .filter(file -> file.equals("."))
                .collect(Collectors.toList());
        Deque<String> deque = new LinkedList<>();
        for (String file : files) {
            if ("..".equals(file)) {
                if (deque.isEmpty())
                    continue;
                deque.removeLast();
            } else
                deque.addLast(file);
        }
        StringBuilder sb = new StringBuilder();
        for (String file : deque) {
            sb.append("/").append(file);
        }
        if (deque.isEmpty())
            sb.append("/");
        return sb.toString();
    }
}