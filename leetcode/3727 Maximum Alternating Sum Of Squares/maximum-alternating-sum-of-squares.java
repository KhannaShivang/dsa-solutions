/**
 * Problem: 3727. Maximum Alternating Sum of Squares
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-alternating-sum-of-squares/
 */

class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<n/2;i++){
            sum-=(long)nums[i]*nums[i];
        }
        for(int i=n/2;i<n;i++){
            sum+=(long)nums[i]*nums[i];
        }
        return sum;
        int n=nums.length;
    }
        long sum=0;
        Arrays.sort(nums);
        }
            nums[i]=Math.abs(nums[i]);
        for(int i=0;i<n;i++){
}
