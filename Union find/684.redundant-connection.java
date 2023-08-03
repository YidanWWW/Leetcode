/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {
    int[] root = null;
    public int[] findRedundantConnection(int[][] edges) {
        //initialize root
        root = new int[edges.length];
        for(int i=0; i<edges.length; i++) root[i] = i+1;

        for(int[] edge:edges) {
            if(findRoot(edge[0])==findRoot(edge[1])) return edge; //if thay have the same root, means we can delete this edge
            union(edge[0], edge[1]);
        }
        return new int[2];
    }

    public int findRoot(int x) {
        if(x==root[x-1]) return x;
        return findRoot(root[x-1]);
    }

    public void union(int x, int y) {
        root[findRoot(y)-1] = x;
    }

}
// @lc code=end

