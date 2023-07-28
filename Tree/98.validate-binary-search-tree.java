/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start

import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //long pre = Long.MIN_VALUE;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        //left-root-right in-order traversal
        if(root==null) return true;

        if(!isValidBST(root.left)) return false;
        //if(pre>=root.val) return false;
        //pre = root.val;
        if(prev!=null && prev.val>=root.val) return false;
        prev = root;
        return isValidBST(root.right);
    }
}

class Solution2 {
    //stack
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur!=null) {
            if(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if(prev!=null && prev.val>=cur.val) return false;
                prev = cur;
                cur = cur.right;
            } 
        }
        return true;
    }
}

// @lc code=end

