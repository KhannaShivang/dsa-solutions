/**
 * Problem: 453. Minimum Moves to Equal Array Elements
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 */

1class Solution {
2    public int minMoves(int[] nums) {
3        int n=nums.length;
4        int sum=0;
5        int min=nums[0];
6        for(int i:nums){
7            sum+=i;
8            min=Math.min(min,i);
9        }
10        return sum-min*n;
11    }
12}
