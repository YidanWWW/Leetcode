/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start

import java.util.Set;

class Solution1 {
    //Time Complexity: O(n^2), Space Complexity: O(n)
    public int removeStones(int[][] stones) {
        //1. dfs
        //number of island
        Set<int[]> visited = new HashSet<>();//store the visited index
        int n = stones.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int[] arr = {stones[i][0],stones[i][1]};
            if(!visited.contains(stones[i])) {
                dfs(stones, visited, arr);
                count++;
            }
        }
        return n-count;

    }

    public void dfs(int[][] stones, Set<int[]> visited, int[]s1){
        visited.add(s1);
        for(int[] s2:stones) {
            if(!visited.contains(s2)) {
                if(s1[0]==s2[0] || s1[1]==s2[1]) dfs(stones, visited, s2);
            } 
        }
    }
}

class Solution {
    //Time Complexity: O(n^2), Space Complexity: O(n)
    int[] root=null;
    int count;
    public int removeStones(int[][] stones) {
        //union find
        //1.find root
        //2. union them
        int n = stones.length;
        root = new int[n];
        count = 0;

        //initialize root array:
        for(int i=0; i<n; i++) root[i] = i;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(stones[i][0]==stones[j][0] || stones[j][1]==stones[i][1]) {
                    union(i, j);
                }
            }
        }
        //if root[x]==x, count++, which means we found an island
        for(int i=0; i<n; i++) {
            if(root[i]==i) count++;
        }
        return n-count;

    }

    public int findRoot(int x) {
        if(x==root[x]) return x;
        return findRoot(root[x]);
    }

    public void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);
        if(x!=y) root[x] = y;
    }
}

// @lc code=end

