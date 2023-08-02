/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if(left==null && right!=null) return false;
        if(left!=null && right==null) return false;

        boolean l = helper(left.left, right.right);
        boolean r = helper(left.right, right.left);
        if(l && r && left.val==right.val) return true;
        return false;
    }
}
// @lc code=end

