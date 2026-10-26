/**
 * Problem: 3619. Count Islands With Total Value Divisible by K
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/
 */

class Solution {
    int m,n;
    private long helper(int i,int j,int[][]grid){
        if(i<0||j<0||i==m||j==n||grid[i][j]==0)return 0;
        long curr=grid[i][j];
        grid[i][j]=0;
        curr+=helper(i-1,j,grid);
        curr+=helper(i+1,j,grid);
        curr+=helper(i,j-1,grid);
        curr+=helper(i,j+1,grid);
        return curr;
    }
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    long sum=helper(i,j,grid);
                    if(sum%k==0)count++;
                }
            }
        }
        return count;
    }
}
