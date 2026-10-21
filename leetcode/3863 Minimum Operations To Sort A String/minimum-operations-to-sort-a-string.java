/**
 * Problem: 3863. Minimum Operations to Sort a String
 * Difficulty: Medium
 * Language: Java
 * Runtime: 0 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-operations-to-sort-a-string/
 */

class Solution {
    private boolean isSorted(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)>s.charAt(i))return false;
        }
        return true;
    }
    public int minOperations(String s) {
        if(isSorted(s))return 0;
        int n=s.length();
        if(n==2)return -1;
        int min=s.charAt(0);
        int max=s.charAt(0);
        int minCount=1;
        int maxCount=1;
        for(int i=1;i<n;i++){
            int ch=s.charAt(i);
            if(ch==min)minCount++;
            if(ch==max)maxCount++;
            if(ch<min){
                min=ch;
                minCount=1;
            }
            if(ch>max){
                max=ch;
                maxCount=1;
