/**
 * Problem: 3665. Twisted Mirror Path Count
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/twisted-mirror-path-count/
 */

class Solution {
    int m,n;
    Integer[][][]dp;
    private int helper(int i,int j,int move,int[][]grid){
        if(i==m||j==n)return 0;
        if(i==m-1&&j==n-1)return 1;
        if(dp[i][j][move]!=null)return dp[i][j][move];
        if(grid[i][j]==1){
            if(move==0)return helper(i+1,j,1,grid);
            return helper(i,j+1,0,grid);
        }
        return dp[i][j][move]=helper(i,j+1,0,grid)+helper(i+1,j,1,grid);
    }
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new Integer[m][n][2];
        return helper(0,0,0,grid);
    }
}
