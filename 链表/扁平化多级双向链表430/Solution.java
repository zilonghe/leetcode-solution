package 链表.扁平化多级双向链表430;

/*
您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node result = head;

        while (head != null) {
            if (head.child != null) {
                Node nextHead = head.next;
                Node childHead = head.child;

                head.next = childHead;
                childHead.prev = head;
                head.child = null;

                concatChildList(childHead, nextHead);
                head = nextHead;
            } else {
                head = head.next;
            }
        }
        return result;
    }

    private void concatChildList(Node childHead, Node nextHead) {
        while (childHead != null) {
            if (childHead.child != null) {
                Node innerNextHead = childHead.next;
                Node innerChildHead = childHead.child;

                childHead.next = innerChildHead;
                innerChildHead.prev = childHead;
                childHead.child = null;

                concatChildList(innerChildHead, innerNextHead);
            }
            if (childHead.next == null) {
                childHead.next = nextHead;
                if (nextHead != null) {
                    nextHead.prev = childHead;
                }
                return;
            } else {
                childHead = childHead.next;
            }
        }
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
