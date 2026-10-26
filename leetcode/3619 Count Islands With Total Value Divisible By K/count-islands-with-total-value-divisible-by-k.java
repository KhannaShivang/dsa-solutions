/**
 * Problem: 3619. Count Islands With Total Value Divisible by K
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0
ms
 * Memory: 0.00
MB
 * LeetCode: https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/
 */

1class Solution {
2    int m,n;
3    private long helper(int i,int j,int[][]grid){
4        if(i<0||j<0||i==m||j==n||grid[i][j]==0)return 0;
5        long curr=grid[i][j];
6        grid[i][j]=0;
7        curr+=helper(i-1,j,grid);
8        curr+=helper(i+1,j,grid);
9        curr+=helper(i,j-1,grid);
10        curr+=helper(i,j+1,grid);
11        return curr;
12    }
13    public int countIslands(int[][] grid, int k) {
14        m=grid.length;
15        n=grid[0].length;
16        int count=0;
17        for(int i=0;i<m;i++){
18            for(int j=0;j<n;j++){
19                if(grid[i][j]!=0){
20                    long sum=helper(i,j,grid);
21                    if(sum%k==0)count++;
22                }
23            }
24        }
25        return count;
26    }
27}
