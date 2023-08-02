/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //level traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1; //count is even, from left to right, if odd,reverse order
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        
            if(count%2==0) list = reverse(list);
            res.add(list);
            count++;
        }
        return res;
    }

    public List<Integer> reverse(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for(int i=list.size()-1; i>=0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
// @lc code=end

