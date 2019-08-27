package 链表.反转链表206;

import 链表.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head.next != null) {
            if (prev == null) {
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next = head;
                prev = tmp;
            } else {
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next = prev;
                prev = tmp;
            }
        }
        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        func(head, result);
        return result.next;
    }

    private ListNode func(ListNode node, ListNode reverseHead) {
        if (node.next == null) {
            reverseHead.next = node;
            node.next = null;
            return node;
        } else {
            ListNode reverseTail = func(node.next, reverseHead);
            reverseTail.next = node;
            node.next = null;
            return node;
        }
    }
}
