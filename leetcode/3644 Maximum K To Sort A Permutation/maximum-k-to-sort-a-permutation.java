/**
 * Problem: 3644. Maximum K to Sort a Permutation
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-k-to-sort-a-permutation/
 */

class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int res=n;
        for(int i=0;i<n;i++){
            if(i!=nums[i]){
                if(res==n)res=nums[i];
                else res&=nums[i];
            }
        }
        if(res==n)return 0;
        return res;
    }
}
