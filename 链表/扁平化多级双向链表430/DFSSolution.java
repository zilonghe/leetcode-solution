package 链表.扁平化多级双向链表430;

public class DFSSolution {

    private Node prev;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        Node next = head.next;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
        }

        prev = head;
        dfs(head.child);
        head.child = null;
        dfs(next);
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int x) {
            val = x;
        }
    }
}
