package binarysearch;

import java.util.*;

/**
 *
 * https://neetcode.io/problems/time-based-key-value-store
 *
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 *
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 * Example 1:
 *
 * Input:
 * ["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]
 *
 * Output:
 * [null, null, "happy", "happy", null, "sad"]
 *
 * Explanation:
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("alice", "happy", 1);  // store the key "alice" and value "happy" along with timestamp = 1.
 * timeMap.get("alice", 1);           // return "happy"
 * timeMap.get("alice", 2);           // return "happy", there is no value stored for timestamp 2, thus we return the value at timestamp 1.
 * timeMap.set("alice", "sad", 3);    // store the key "alice" and value "sad" along with timestamp = 3.
 * timeMap.get("alice", 3);           // return "sad"
 *
 */
public class TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> map;

    public TimeBasedKeyValueStore() {
       map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        TreeMap<Integer, String> timeMap = map.get(key);
        String val = timeMap.get(timestamp);

        if (val != null) return val;

        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
