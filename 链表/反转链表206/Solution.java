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
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(next, cur);
    }
}
