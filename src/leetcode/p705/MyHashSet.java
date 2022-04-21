package leetcode.p705;
// https://leetcode.com/problems/design-hashset/

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    private final int INDEX_SIZE= 10000;
    private List<List<Integer>> hashTable;

    public MyHashSet() {
        hashTable= new ArrayList<>();
        for (int i=0; i < INDEX_SIZE; ++i) {
            hashTable.add(new ArrayList<Integer>());
        }
    }

    public void add(int key) {
        List<Integer> group= hashTable.get(key%INDEX_SIZE);
        if (!group.contains(key)) {
            group.add(key);
        }
    }

    public void remove(Integer key) {
        List<Integer> group= hashTable.get(key%INDEX_SIZE);
        if (group.contains(key)) {
            group.removeIf(key::equals);
        }
    }

    public boolean contains(int key) {
        List<Integer> group= hashTable.get(key%INDEX_SIZE);
        return group.contains(key);
    }
}
