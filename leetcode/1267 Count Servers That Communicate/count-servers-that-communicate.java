/**
 * Problem: 1267. Count Servers that Communicate
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/count-servers-that-communicate/
 */

class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]activeInRows=new int[m];
        int[]activeInCols=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    activeInRows[i]++;
                    activeInCols[j]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(activeInRows[i]>1||activeInCols[j]>1)count++;
                }
            }
        }
        return count;
    }
}
