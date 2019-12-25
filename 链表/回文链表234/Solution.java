package 链表.回文链表234;

import 链表.ListNode;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
class Solution {
//    private Stack<Integer> stringStack = new Stack<>();
//    public boolean isPalindrome(ListNode head) {
//        ListNode dummy = head;
//        while (dummy != null) {
//            stringStack.push(dummy.val);
//            dummy = dummy.next;
//        }
//        while (head != null && (stringStack.pop() == head.val)) {
//            head = head.next;
//        }
//        return head == null;
//    }

    public boolean isPalindrome(ListNode head) {
        // O(N)时间，O(1)空间复杂度解法
        if (head == null || head.next == null) {
            return true;
        }
        // 1. 快慢指针法，找到链表中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2.将后半部分反转，遍历两个链表对比值
        slow = reverse(slow.next, null);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
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
