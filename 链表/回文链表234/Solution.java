package 链表.回文链表;

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
    private Stack<Integer> stringStack = new Stack<>();
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = head;
        while (dummy != null) {
            stringStack.push(dummy.val);
            dummy = dummy.next;
        }
        while (head != null && (stringStack.pop() == head.val)) {
            head = head.next;
        }
        return head == null;
    }
}
