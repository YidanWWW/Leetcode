/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        //j/3+(i/3)*3 6+1=7
        //box[(i/3)*3+j/3]

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                int cur = board[i][j]-'0';
                if(board[i][j]=='.') continue;
                if(row[i][cur]==1) return false;
                if(col[j][cur]==1) return false;
                if(box[(i/3)*3 + j/3][cur]==1) return false; 
                row[i][cur]=1;
                col[j][cur] = 1;
                box[(i/3)*3 + j/3][cur]=1;

            }
        }
        return true;

    }
}
// @lc code=end

