/*
 * @lc app=leetcode id=2196 lang=java
 *
 * [2196] Create Binary Tree From Descriptions
 */

// @lc code=start

import java.util.HashMap;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>(); //store all the children nodes to find toe root
        for(int[] d : descriptions) {
            int parent = d[0], children = d[1], isLeft = d[2];
            set.add(children);
            TreeNode node = map.getOrDefault(parent, new TreeNode(parent));
            if(isLeft==1) {
                node.left = map.getOrDefault(children, new TreeNode(children));
                map.put(children, node.left);
            }else {
                node.right = mao.getOrDefault(children, new TreeNode(children));
                map.put(children, node.right);
            }
            map.put(parent, node);
        }
        int root = -1;
        for(int[] arr:descriptions) {
            if(!set.contains(arr[0])) {
                root=arr[0];
                break;
            }
        }
        return map.getOrDefault(root, null);
    }
}
// @lc code=end

