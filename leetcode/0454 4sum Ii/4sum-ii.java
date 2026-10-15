/**
 * Problem: 454. 4Sum II
 * Difficulty: Medium
 * Language: Java
 * Runtime: 1 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/4sum-ii/
 */

class Solution {
    private int search(int []nums,int val){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=val)low=mid+1;
            else high=mid-1;
        }
        return low;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums4);
        int n=nums1.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    int curr=nums1[i]+nums2[j]+nums3[k];
                    int left=search(nums4,-curr-1)-1;
                    int right=search(nums4,-curr);
                    count+=right-left-1;
                }
            }
        }
        return count;
    }
}
