/**
 * Problem: 1254. Number of Closed Islands
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/number-of-closed-islands/
 */

class Solution {
    int m,n;
    private int check(int i,int j,int[][]grid){
        if(i<0||i==m||j<0||j==n)return 0;
        if(grid[i][j]==1)return 1;
        grid[i][j]=1;
        int curr=1;
        curr&=check(i,j+1,grid);
        curr&=check(i,j-1,grid);
        curr&=check(i+1,j,grid);
        curr&=check(i-1,j,grid);
        return curr;
    }
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count+=check(i,j,grid);
                }
            }
        }
        return count;
    }
}
