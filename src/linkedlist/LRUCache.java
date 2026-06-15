package linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;

        }
    }

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;


    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;

        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }


    // Build In way
    static class LRUCache2 {
        private final Map<Integer, Integer> cache;
        private final int capacity;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > LRUCache2.this.capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }
}
