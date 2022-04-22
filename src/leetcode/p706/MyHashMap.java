package leetcode.p706;
// https://leetcode.com/problems/design-hashmap/

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private final int BUCKETS= 10000;
    private List<List<HashNode>> hashTable;
    private class HashNode {
        public Integer key, value;

        HashNode(Integer key, Integer value) {
            this.key= key;
            this.value= value;
        }
    }

    public MyHashMap() {
        hashTable = new ArrayList<>();
        for (int i=0; i < BUCKETS; ++i) {
            hashTable.add(new ArrayList<>());
        }
    }

    private HashNode findHashNode(Integer key) {
        int keyIndex = key%BUCKETS;
        return hashTable.get(keyIndex).stream()
                .filter(node -> node.key.equals(key))
                .findAny().orElse(null);
    }

    public void put(Integer key, Integer value) {
        HashNode node = findHashNode(key);
        if (node != null) {
            node.value = value;
        }
        else {
            hashTable.get(key%BUCKETS).add(new HashNode(key,value));
        }
    }

    public int get(int key) {
        HashNode node = findHashNode(key);
        if (node != null) return node.value;
        else return -1;
    }

    public void remove(int key) {
        HashNode node = findHashNode(key);
        if (node != null) hashTable.get(key%BUCKETS).remove(node);
    }
}