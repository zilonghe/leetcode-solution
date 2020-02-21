package 哈希表.设计哈希集合;

import 链表.ListNode;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 */
class MyHashSet {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    private final int bucketSize = 10000;

    private ListNode[] nodes = new ListNode[bucketSize];

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public void add(int key) {
        int index = key % bucketSize;
        ListNode buckets = nodes[index];
        ListNode newNode = new ListNode(key);
        if (buckets == null) {
            nodes[index] = newNode;
        } else {
            while (buckets.next != null) {
                if (buckets.val == key) {
                    return;
                }
                buckets = buckets.next;
            }
            if (buckets.val == key) {
                return;
            }
            buckets.next = newNode;
        }
    }

    public void remove(int key) {
        int index = key % bucketSize;
        ListNode buckets = nodes[index];
        if (buckets != null) {
            ListNode prev = null;
            while (buckets.next != null) {
                if (buckets.val == key) {
                    if (prev == null) {
                        nodes[index] = buckets.next;
                        return;
                    }
                    prev.next = buckets.next;
                    return;
                }
                prev = buckets;
                buckets = buckets.next;
            }
            if (buckets.val == key) {
                if (prev == null) {
                    nodes[index] = null;
                } else {
                    prev.next = null;
                }
            }
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % bucketSize;
        ListNode buckets = nodes[index];
        if (buckets == null) {
            return false;
        }
        while (buckets.next != null) {
            if (buckets.val == key) {
                return true;
            }
            buckets = buckets.next;
        }
        return buckets.val == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
