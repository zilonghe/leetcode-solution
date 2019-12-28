package 链表.复制带随机指针的链表138;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    private Node next = null;
    private List<Node> originList = new ArrayList<>();
    private List<Node> newList = new ArrayList<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        traverse(head);
        Node result = next;
        while(head != null) {
            if(head.random != null) {
                int randomIndex = originList.indexOf(head.random);
                next.random = newList.get(randomIndex);
            }
            next = next.next;
            head = head.next;
        }
        return result;
    }

    private void traverse(Node head) {
        if(head == null) {
            return;
        }
        originList.add(head);
        traverse(head.next);
        Node cur = new Node(head.val);
        newList.add(0, cur);
        if(next != null) {
            cur.next = next;
            next = cur;
        } else {
            next = cur;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
