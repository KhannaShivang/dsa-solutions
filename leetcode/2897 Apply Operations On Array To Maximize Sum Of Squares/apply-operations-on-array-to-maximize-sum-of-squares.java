/**
 * Problem: 2897. Apply Operations on Array to Maximize Sum of Squares
 * Difficulty: Hard
 * Language: Java
 * Runtime: N/A
 * Memory: N/A
 * LeetCode: https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
 */

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[]count=new int[31];
        for(int i:nums){
            for(int bit=0;bit<31;bit++){
                count[bit]+=i>>bit&1;
            }
        }
        long sum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<k;i++){
            long curr=0;
            for(int bit=0;bit<31;bit++){
                if(count[bit]!=0){
                    count[bit]--;
                    curr|=1<<bit;
                }
            }
            sum=(sum+curr*curr)%mod;
        }
        return (int)sum;
    }
}
