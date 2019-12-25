package 链表.合并两个有序链表21;

import 链表.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = null;
        ListNode head = null;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                if (result == null) {
                    result = l2;
                    head = result;
                } else {
                    result.next = l2;
                    result = result.next;
                }
                l2 = l2.next;
            } else {
                if (result == null) {
                    result = l1;
                    head = result;
                } else {
                    result.next = l1;
                    result = result.next;
                }
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            result.next = l2;
        } else {
            result.next = l1;
        }
        return head;
    }
}