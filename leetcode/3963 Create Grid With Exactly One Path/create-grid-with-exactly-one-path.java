/**
 * Problem: 3963. Create Grid With Exactly One Path
 * Difficulty: Easy
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/create-grid-with-exactly-one-path/
 */

class Solution {
    public String[] createGrid(int m, int n) {
        String[]res=new String[m];
        for(int i=0;i<m-1;i++){
            StringBuilder sb=new StringBuilder(".");
            for(int j=0;j<n-1;j++){
                sb.append('#');
            }
            res[i]=sb.toString();
        }
        res[m-1]=".".repeat(n);
        return res;
    }
}
