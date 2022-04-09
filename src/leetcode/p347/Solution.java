package leetcode.p347;
// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair implements Comparable<Pair> {
    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(final Pair o) {
        if (x == o.getX()) return Integer.compare(y, o.getY());
        return Integer.compare(x, o.getX());
    }
}

class Solution {
    private Map<Integer, Integer> freqMap;

    public int[] topKFrequent(int[] nums, int k) {
        freqMap= new HashMap<>();
        for (int num : nums) {
            Integer freq= freqMap.get(num);
            if (freq == null) freq= 0;
            freqMap.put(num, freq+1);
        }
        List<Pair> freqList = new ArrayList<>();
        for (Integer key : freqMap.keySet()) {
            freqList.add(new Pair(freqMap.get(key), key));
        }
        Collections.sort(freqList, Collections.reverseOrder());
        int ret[]= new int[k];
        for (int i=0; i < k; ++i) ret[i]= freqList.get(i).getY();
        return ret;
    }
}