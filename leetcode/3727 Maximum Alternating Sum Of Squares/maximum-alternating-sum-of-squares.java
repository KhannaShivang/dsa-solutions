/**
 * Problem: 3727. Maximum Alternating Sum of Squares
 * Difficulty: Medium
 * Language: Java
 * Runtime: 34
ms
 * Memory: 126.01
MB
 * LeetCode: https://leetcode.com/problems/maximum-alternating-sum-of-squares/
 */

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<n/2;i++){
            sum-=(long)nums[i]*nums[i];
        }
        for(int i=n/2;i<n;i++){
            sum+=(long)nums[i]*nums[i];
        }
        return sum;
    }
}
