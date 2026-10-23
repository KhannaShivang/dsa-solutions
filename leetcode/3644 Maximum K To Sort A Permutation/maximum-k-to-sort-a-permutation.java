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
        int low=0;
        int high=n;
        Integer[]idx=new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx,(a,b)->nums[a]-nums[b]);
        int res=n;
        for(int i=0;i<n;i++){
            if(i!=idx[i]){
                if(res==n)res=nums[i];
                res&=nums[i]&nums[idx[i]];
            }
        }
        if(res==n)return 0;
        return res;
    }
}
