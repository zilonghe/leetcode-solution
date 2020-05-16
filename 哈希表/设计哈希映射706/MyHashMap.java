package 哈希表.设计哈希映射706;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射
 * <p>
 * 具体地说，你的设计应该包含以下的功能
 * <p>
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * <p>
 * 示例：
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * <p>
 * 注意：
 * <p>
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 */
class MyHashMap {

    private int arraySize = 10000;

    private ListNode[] array = new ListNode[arraySize];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = key % arraySize;
        ListNode bucket = array[index];
        if (bucket == null) {
            array[index] = new ListNode(key, value);
            return;
        }
        ListNode dummy = new ListNode(-1, -1);
        dummy.next = bucket;
        while (dummy.next != null) {
            if (dummy.next.key == key) {
                dummy.next.val = value;
                return;
            }
            dummy = dummy.next;
        }
        dummy.next = new ListNode(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = key % arraySize;
        ListNode bucket = array[index];
        while (bucket != null) {
            if (bucket.key == key) {
                return bucket.val;
            }
            bucket = bucket.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = key % arraySize;
        ListNode bucket = array[index];
        ListNode dummy = new ListNode(-1, -1);
        dummy.next = bucket;
        ListNode pre = null;
        while (dummy.next != null) {
            if (dummy.next.key == key) {
                if (pre == null) {
                    array[index] = dummy.next.next;
                    return;
                }
                pre.next = dummy.next.next;
                return;
            }
            pre = dummy.next;
            dummy = dummy.next;
        }
    }

    public static class ListNode {
        public int key;

        public int val;

        public ListNode next;

        ListNode(int x, int y) {
            key = x;
            val = y;
            next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
