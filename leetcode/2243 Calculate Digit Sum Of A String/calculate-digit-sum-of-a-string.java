/**
 * Problem: 2243. Calculate Digit Sum of a String
 * Difficulty: Easy
 * Language: Java
 * Runtime: 1ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/calculate-digit-sum-of-a-string/
 */

class Solution {
    private int helper(String s){
        int sum=0;
        for(char ch:s.toCharArray()){
            sum+=ch-'0';
        }
        return sum;
    }
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder();
        while(s.length()>k){
            int idx=0;
            while(idx<s.length()){
                sb.append(helper(s.substring(idx,Math.min(idx+k,s.length()))));
                idx+=k;
            }
            s=sb.toString();
            sb.setLength(0);
        }
        return s;
    }
}
