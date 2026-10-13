/**
 * Problem: 424. Longest Repeating Character Replacement
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/longest-repeating-character-replacement/
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[][]letterScore=new int[26][n];
        for(int i=0;i<n;i++){
            int letter=s.charAt(i)-'A';
            letterScore[letter][i]=1;
        }
        int max=0;
        for(int i=0;i<n;i++){
            int left=0;
            int count=0;
            for(int right=0;right<n;right++){
                count+=letterScore[i][right];
                while(right-left+1-count>k){
                    count-=letterScore[i][left++];
                }
                max=Math.max(max,right-left+1);
            }
        }
        return max;
    }
}
