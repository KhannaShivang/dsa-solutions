/**
 * Problem: 3963. Create Grid With Exactly One Path
 * Difficulty: Easy
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/create-grid-with-exactly-one-path/
 */

1class Solution {
2    public String[] createGrid(int m, int n) {
3        String[]res=new String[m];
4        for(int i=0;i<m-1;i++){
5            StringBuilder sb=new StringBuilder(".");
6            for(int j=0;j<n-1;j++){
7                sb.append('#');
8            }
9            res[i]=sb.toString();
10        }
11        res[m-1]=".".repeat(n);
12        return res;
13    }
14}
