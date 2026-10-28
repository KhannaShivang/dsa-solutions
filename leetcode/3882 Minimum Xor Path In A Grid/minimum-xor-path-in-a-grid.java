/**
 * Problem: 3882. Minimum XOR Path in a Grid
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-xor-path-in-a-grid/
 */

class Solution {
    int res;
    boolean[][][]vis;
    private void helper(int i,int j,int x,int[][]grid){
        if(i<0||j<0)return;
        x^=grid[i][j];
        if(vis[i][j][x])return;
        vis[i][j][x]=true;
        if(i==0&&j==0){
            res=Math.min(res,x);
            return;
        }
        helper(i,j-1,x,grid);
        helper(i-1,j,x,grid);
    }
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        res=Integer.MAX_VALUE;
        vis=new boolean[m][n][1024];
        helper(m-1,n-1,0,grid);
        return res;
    }
}
