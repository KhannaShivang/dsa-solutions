/**
 * Problem: 1267. Count Servers that Communicate
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/count-servers-that-communicate/
 */

1class Solution {
2    public int countServers(int[][] grid) {
3        int m=grid.length;
4        int n=grid[0].length;
5        int[]activeInRows=new int[m];
6        int[]activeInCols=new int[n];
7        for(int i=0;i<m;i++){
8            for(int j=0;j<n;j++){
9                if(grid[i][j]==1){
10                    activeInRows[i]++;
11                    activeInCols[j]++;
12                }
13            }
14        }
15        int count=0;
16        for(int i=0;i<m;i++){
17            for(int j=0;j<n;j++){
18                if(grid[i][j]==1){
19                    if(activeInRows[i]>1||activeInCols[j]>1)count++;
20                }
21            }
22        }
23        return count;
24    }
25}
