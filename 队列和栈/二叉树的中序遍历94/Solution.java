package 队列和栈.二叉树的中序遍历94;

import java.util.*;
/*
* 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * <p>
 * <p>
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> result = new ArrayList<>();
    private Stack<TreeNode> stack = new Stack<>();
    private Set<TreeNode> visited = new HashSet<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;
        System.out.println(new Solution().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        //recurFunc(root);

        // 迭代解法，主要就是用栈和while模拟递归
        stack.push(root);
        visited.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur == null) {
                stack.pop();
                continue;
            }
            TreeNode leftNode = cur.left;
            if (leftNode != null && !visited.contains(leftNode)) {
                stack.push(leftNode);
                visited.add(leftNode);
            } else {
                result.add(cur.val);
                stack.pop();
                stack.push(cur.right);
                visited.add(cur.right);
            }
        }
        return result;
    }

    /**
     * 递归解法
     */
    private void recurFunc(TreeNode root) {
        if (root == null) {
            return;
        }
        recurFunc(root.left);
        result.add(root.val);
        recurFunc(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
