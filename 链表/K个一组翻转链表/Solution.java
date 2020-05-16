package 链表.K个一组翻转链表;

import 链表.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        //1.滑动窗口法，如果剩余链表大小和窗口大小非整数倍，直接返回当前链表
        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;
        ListNode result = head;
        while (q != null) {
            for (int i = 0; i < k; i++) {
                // 滑动窗口
                if (q == null) {
                    return result;
                }
                q = q.next;
            }
            // 将窗口内的元素翻转
            ListNode reverseHead = reverse(p, q, q);
            if (pre == null) {
                result = reverseHead;
            } else {
                pre.next = reverseHead;
            }
            pre = p;
            p = q;
        }
        return result;
    }

    private ListNode reverse(ListNode cur, ListNode pre, ListNode end) {
        if (cur == end) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(next, cur, end);
    }
}
