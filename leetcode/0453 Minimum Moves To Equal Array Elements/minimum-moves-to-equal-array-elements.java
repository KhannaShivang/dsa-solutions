/**
 * Problem: 453. Minimum Moves to Equal Array Elements
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 */

class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int sum=0;
        int min=nums[0];
        for(int i:nums){
            sum+=i;
            min=Math.min(min,i);
        }
        return sum-min*n;
    }
}
