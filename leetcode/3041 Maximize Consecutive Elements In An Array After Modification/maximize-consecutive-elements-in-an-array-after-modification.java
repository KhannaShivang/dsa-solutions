/**
 * Problem: 3041. Maximize Consecutive Elements in an Array After Modification
 * Difficulty: Hard
 * Language: Java
 * Runtime: 2 ms
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/
 */

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int max=1;
        int curr=1;
        int n=nums.length;
        int carry=0;
        int last=0;
        int lastUpdate=0;
        for(int i=1;i<n;i++){
            if(nums[last]+carry>nums[i])continue;
            if(nums[last]+carry==nums[i]){
                curr++;
                carry=1;
                lastUpdate=curr;
            }
            else if(nums[last]+carry==nums[i]-1){
                curr++;
                carry=0;
            }
            else if(nums[last]==nums[i]-2){
                int t=curr;
                curr=curr-lastUpdate+1;
                lastUpdate=t;
                carry=0;

            }
            else{
                curr=1;
                carry=0;
            }
            last=i;
            max=Math.max(max,curr);
        }
        return max;
    }
}
