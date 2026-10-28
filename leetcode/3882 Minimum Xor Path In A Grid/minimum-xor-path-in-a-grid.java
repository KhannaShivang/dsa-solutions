/**
 * Problem: 3882. Minimum XOR Path in a Grid
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-xor-path-in-a-grid/
 */

1class Solution {
2    int res;
3    HashSet<Integer>set;
4    private void helper(int i,int j,int x,int[][]grid){
5        if(i<0||j<0)return;
6        x^=grid[i][j];
7        int key=(i*1000+j)*1000+x;
8        if(set.contains(key))return;
9        set.add(key);
10        if(i==0&&j==0){
11            res=Math.min(res,x);
12            return;
13        }
14        helper(i,j-1,x,grid);
15        helper(i-1,j,x,grid);
16    }
17    public int minCost(int[][] grid) {
18        int m=grid.length;
19        int n=grid[0].length;
20        res=Integer.MAX_VALUE;
21        set=new HashSet<>();
22        helper(m-1,n-1,0,grid);
23        return res;
24    }
25}
