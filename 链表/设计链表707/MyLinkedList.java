package 链表.设计链表707;

class MyLinkedList {

    private int length;
    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node target = getNodeAtIndex(index);
        if (target != null) {
            return target.val;
        } else {
            return -1;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node tmp = head;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
        }
        length++;
        if (tmp == null) {
            head = new Node(val);
            return;
        }
        tmp.next = new Node(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node target = getNodeAtIndex(index - 1);
        if (target != null) {
            Node newNode = new Node(val);
            newNode.next = target.next;
            target.next = newNode;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= length || index < 0) {
            return;
        }
        if (index == 0) {
            if (head != null) {
                head = head.next;
                length--;
            }
            return;
        }
        Node target = getNodeAtIndex(index - 1);
        if (target != null) {
            if (target.next != null) {
                target.next = target.next.next;
                length--;
            }
        }
    }

    private Node getNodeAtIndex(int index) {
        if (null == head || index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return head;
        }
        Node tmp = head;
        while (index > 0) {
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }

    public class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
