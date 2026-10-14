/**
 * Problem: 3723. Maximize Sum of Squares of Digits
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
 */

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num>sum||num*9<sum)return "";
        StringBuilder sb=new StringBuilder();
        while(sum>9){
            sb.append(9);
            sum-=9;
        }
        sb.append(sum);
        for(int i=sb.length();i<num;i++){
            sb.append(0);
        }
        return sb.toString();
    }
}
