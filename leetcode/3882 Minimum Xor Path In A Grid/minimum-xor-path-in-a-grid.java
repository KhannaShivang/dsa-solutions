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
    HashSet<Integer>set;
    private void helper(int i,int j,int x,int[][]grid){
        if(i<0||j<0)return;
        x^=grid[i][j];
        int key=(i*1000+j)*1000+x;
        if(set.contains(key))return;
        set.add(key);
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
        set=new HashSet<>();
        helper(m-1,n-1,0,grid);
        return res;
    }
}
