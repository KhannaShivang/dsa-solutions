/**
 * Problem: 4066. Maximum Equal Adjacent Pairs After at Most One Replacement
 * Difficulty: Medium
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/
 */

class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n=nums.length;
        HashMap<Long,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1])count++;
            else{
                long a=nums[i];
                long b=nums[i+1];
                if(a>b){
                    a=a^b;
                    b=a^b;
                    a=a^b;
                }
                long key = a<<32|b;
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        int max=0;
        for(int i:map.values()){
            max=Math.max(max,i);
        }
        return count+max;
    }
}
